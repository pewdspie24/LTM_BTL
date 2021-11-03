/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import model.Request;
import model.User;
import view.GUI_Game;
import view.GUI_Home;
import view.ItemModel;

/**
 *
 * @author nguye
 */
public class Controller implements Runnable {
    Socket socket = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    boolean is_running = true;
    
    public Controller(Socket socket) {
        this.socket = socket;
    }
    
    @Override
    public void run() {
        try {
            ois = new ObjectInputStream(this.socket.getInputStream());
            while (is_running) {
                Request response = (Request) ois.readObject();
                switch (response.action) {
                    case "login":
                        this.login(response);
                        break;
                    case "signup":
                        if ("existed".equalsIgnoreCase(response.message)) {
                            JOptionPane.showMessageDialog(null, "the Account has existed");
                        }
                        break;
                    case "loadOnline":
                        this.resetOnlineList(response.onlineList);
                        this.showOnlineList(GameClient.onlineList);
                        break;
                    case "rank":
                        GameClient.gui_rank.setVisible(true);
                        GameClient.gui_rank.showRank(response.rank);
                        break;
                    case "challenge":
                        this.challenge(response.user);
                        break;
                    case "repChallenge":
                        this.repChallenge(response);
                        break;
                    case "result":
                        this.result(response);
                        break;
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Disconnected!");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resetOnlineList(ArrayList<User> users){
        GameClient.onlineList.clear();
        GameClient.onlineList.addAll(users);
    }
    
    public void login(Request req) {
        if ("ok".equals(req.message)) {
            GameClient.user = req.user;
            GameClient.isLogin = true;
            //Show GUI_Home
            GameClient.gui_home.nickName.setText(GameClient.user.getNickname());
            GameClient.gui_home.cbStatus.setSelectedItem(GameClient.user.getStatus() == 1 ? "Online" : "Busy");
            GameClient.gui_home.setVisible(true);
            //hide gui_login
            GameClient.gui_login.setVisible(false);
            GameClient.gui_signup.setVisible(false);
            JOptionPane.showMessageDialog(null, "Login success");
        } else {
            JOptionPane.showMessageDialog(null, req.message);
        }
    }
    
    public void showOnlineList(ArrayList<User> users) {
        int online = users.size();
        int idUser = GameClient.user.getId();
        DefaultListModel<User> model = new DefaultListModel();
        for (User user : users) {
            if (user.getId() != idUser) {
                model.addElement(user);
            }
        }
        GUI_Home.onlineList.setModel(model);
        GUI_Home.onlineList.setCellRenderer(new ItemModel());
    }
    
    public void challenge(User user) throws IOException {
        GameClient.gui_game.setVisible(false);
        GameClient.gui_gameover.setVisible(false);
        int comfirm = JOptionPane.showConfirmDialog(null, user.getNickname().toUpperCase() + " wants to challenge you.\n Do you agree?");
        oos = new ObjectOutputStream(GameClient.socket.getOutputStream());
        Request req = new Request(0);
        req.action = "repChallenge";
        req.user = user;
        if (comfirm == 0) {
            req.message = "yes";
        } else {
            req.message = "no";
        }
        oos.writeObject(req);
        oos.flush();
    }
    
    public void repChallenge(Request req) throws IOException {
        if ("yes".equalsIgnoreCase(req.message)) {
            GameClient.gui_game = new GUI_Game(req.questions, GameClient.socket, Integer.parseInt(req.data[0]), req.user);
            GameClient.gui_game.play();
        } else {
            JOptionPane.showMessageDialog(null, req.user.getNickname().toUpperCase() + " has refused");
        }
    }
    
    public void result(Request req) {
        if ("win".equals(req.message)) {
            GameClient.gui_game.showResult("You win!!!");
            GameClient.gui_game.time.stop();
            return;
        }
        if ("lose".equals(req.message)) {
            GameClient.gui_game.showResult("You lose!!!");
            GameClient.gui_game.time.stop();
            GameClient.gui_game.btnSubmit.setEnabled(false);
            return;
        }
        GameClient.gui_game.showResult("You have a draw!!!");
        GameClient.gui_game.time.stop();
    }
}
