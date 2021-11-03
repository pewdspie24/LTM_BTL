/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.Constant;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;
import model.User;
import view.GUI_DetailGame;
import view.GUI_Game;
import view.GUI_GameOver;
import view.GUI_Home;
import view.GUI_Login;
import view.GUI_Rank;
import view.GUI_Signup;

/**
 *
 * @author nguye
 */
public class GameClient implements Constant {

    public static Socket socket = null;
    public static User user = null;
    public static boolean isLogin = false;
    public static ArrayList<User> onlineList = new ArrayList<>();
    public static GUI_Home gui_home = null;
    public static GUI_Rank gui_rank = null;
    public static GUI_Login gui_login = null;
    public static GUI_Signup gui_signup = null;
    public static GUI_Game gui_game = null;
    public static GUI_GameOver gui_gameover = null;
    public static GUI_DetailGame gui_detailgame = null;
    public static ArrayList<Question> questions = new ArrayList<>();

    public void init() {
        try {
            GameClient.socket = new Socket(IP_SERVER, SOCKET_PORT);
            new Thread(new Controller(GameClient.socket)).start();
            GameClient.gui_login = new GUI_Login();
            GameClient.gui_login.setVisible(true);
            GameClient.gui_home = new GUI_Home();
            GameClient.gui_signup = new GUI_Signup();
            GameClient.gui_game = new GUI_Game(questions, socket, Constant.TIME_PLAY, user);
            GameClient.gui_gameover = new GUI_GameOver("", this.gui_game);
            GameClient.gui_rank = new GUI_Rank();
        } catch (IOException ex) {
            System.out.println("The server is not start");
        }

    }

    public static void main(String[] args) {
        GameClient game_client = new GameClient();
        game_client.init();
    }
}
