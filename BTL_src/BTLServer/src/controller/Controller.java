/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.History;
import model.MD5;
import model.Match;
import model.Request;
import model.Player;
import model.Question;
import model.User;
import view.GUI_Server;

/**
 *
 * @author nguye
 */
public class Controller {

    Connection con;
    GUI_Server gui_server;
    public Controller(Connection con,GUI_Server gui_server) {
        this.con = con;
        this.gui_server = gui_server;
    }
    // xử lý rank trả về
    public void sendRank(String text, Player player) throws IOException {
        Request req = new Request(0);
        req.action = "rank";
        req.rank = getRank(10,text);
        player.oos.writeObject(req);
        player.oos.flush();
    }
    // gửi lịch sử đấu
    public void repHistory(User user, Player player) throws IOException{
        Request req = new Request(0);
        req.action = "history";
        req.historys = getHistorys(user.getUsername());
//        req.message = user.getNickname() + "|" + this.getNNFromID(req.historys)
        player.oos.writeObject(req);
        player.oos.flush();
    }
// lấy rank ra từ csdl
    public ArrayList<User> getRank(int i, String text) {
        String query;
        if(text.compareTo("time") == 0){
            query = "SELECT * FROM `users` WHERE time > 0 AND scores > 0 ORDER BY `" + text + "` ASC ";
        }
        else{
            query = "SELECT * FROM `users` WHERE scores > 0 ORDER BY `" + text + "` DESC ";
        }
        ResultSet result;
        ArrayList<User> list = new ArrayList<>();
        User user;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            result = ps.executeQuery();
            while (result.next()) {
                user = createUser(result);
                list.add(user);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
// login
    public int login(Request req, Player player) throws IOException {
        Request request = new Request(0);
        request.action = "login";
//        for(Player p : gui_server.onlinePlayer){
//            this.sendOnlineList(p.oos, gui_server.onlineList);
//        }
//        System.out.println(this.checkLogin(gui_server.onlineList, req.data[0]));
        if (this.checkLogin(gui_server.onlineList, req.data[0])) {
            User user = this.getUser(req.data[0], req.data[1]);
            if (user != null) {
                player.user = user;
                player.status = 1;
                gui_server.addPlayer(player);
                request.user = player.user;
                request.message = "ok";
                player.oos.writeObject(request);
                player.oos.flush();
                for(Player p : gui_server.onlinePlayer){
                    this.sendOnlineList(p.oos, gui_server.onlineList);
                }
                return 1;
            }
            request.message = "Username or password are incorrect";
            player.oos.writeObject(request);
            player.oos.flush();
            return 0;
        }
        request.message = "Player is online";
        player.oos.writeObject(request);
        player.oos.flush();
        return 2;
    }
    
    public void logout(Request req, Player player) throws IOException{
        Request request = new Request(0);
        player.status = 0;
        gui_server.removePlayer(player);
        request.action = "logout";
        player.oos.writeObject(request);
        player.oos.flush();
//        System.out.println(this.checkLogin(gui_server.onlineList, player.getUser().getUsername()));
        for(Player p : gui_server.onlinePlayer){
            this.sendOnlineList(p.oos, gui_server.onlineList);
        }
    }
// lấy ra một user
    public User getUser(String username, String password) {
        try {
            String query = "SELECT * From `users` WHERE `username` = ? AND `password` = ?";
            ResultSet result;

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, username);
                ps.setString(2, MD5.md5(password));

                result = ps.executeQuery();
                result.last();

                if (result.getRow() != 0) {
                    return createUser(result);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getNNFromID(int id) {
        try {
            String query = "SELECT nickname From `users` WHERE `id` = ?";
            ResultSet result;

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, id);
                result = ps.executeQuery();
                result.last();

                if (result.getRow() != 0) {
                    return result.getString("nickname");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
// kiểm tra user đã login hay chưa
    public boolean checkLogin(ArrayList<User> list, String username) {
        for (User user : list) {
            if (username.equals(user.getUsername())) {
                return false;
            }
        }
        return true;
    }
    // check xem user đó đã tồn tại trong csdl hay chưa
    public boolean checkUser(String username) {
        try {
            String query = "SELECT * From `users` WHERE `username` = ?";
            ResultSet result;
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, username);
                result = ps.executeQuery();
                if (result.first()) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
// đăng kí
    public int signup(String[] data, Player player) throws IOException {
        Request req = new Request(3);
        if (checkUser(data[0])) {
            req.action = "signup";
            req.message = "existed";
            player.oos.writeObject(req);
            player.oos.flush();
            return 0;
        } else {
            req.action = "signup";
            addUser(data);
            player.oos.writeObject(req);
            player.oos.flush();
            return 1;
        }
    }
// thêm user vào csdl
    public void addUser(String[] data) {
        try {
            String query = "INSERT INTO `users` (`username`, `password`, `nickname`, `scores`, `matches`, `win`, `time`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, data[0]);
                ps.setString(2, MD5.md5(data[1]));
                ps.setString(3, data[2]);
                ps.setDouble(4, 0);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setInt(7, 0);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

// đóng gói user khi query ra cho nó vào list
    public User createUser(ResultSet result) {
        try {
            User user = new User();
            user.setId(result.getInt("id"));
            user.setNickname(result.getString("nickname"));
            user.setUsername(result.getString("username"));
            user.setPassword(result.getString("password"));
            user.setNumOfmatches(result.getInt("matches"));
            user.setWin(result.getInt("win"));
            user.setScore(result.getDouble("scores"));
            user.setTime(result.getInt("time"));
            user.setStatus(1);

            return user;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
// trả về danh sách người chơi online
    public void sendOnlineList(ObjectOutputStream oos, ArrayList<User> list) throws IOException {
        Request req = new Request(0);
        oos.reset();
        req.action = "loadOnline";
        req.onlineList = list;
        oos.writeObject(req);
        oos.flush();
    }
    public void sendMessage(ArrayList<Player> list, String chat, User user) throws IOException{
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");   
        Date date = new Date();    
        String timenow = formatter.format(date);  
        for (Player player : list){
            Request req = new Request(0);
            req.action = "broadcastMessage";
            req.message = user.getNickname()+" ("+timenow+"): "+chat;
            ObjectOutputStream oos = player.oos;
            oos.writeObject(req);
            oos.flush();
        }
        
    }
// gửi yêu cầu thách đấu
    public void challenge(ArrayList<Player> list, User user1, User user2) throws IOException {
        Player player = getPlayer(list, user1.getUsername());
        ObjectOutputStream oos = player.oos;
        Request req = new Request(0);
        req.action = "challenge";
        req.user = user2;
        oos.writeObject(req);
        oos.flush();
    }
// trả lời thách đấu và gửi list câu hỏi để 2 đối thủ chơi với nhau
    public void repChallenge(Request request, Player player1) throws IOException {
        Player player = getPlayer(gui_server.onlinePlayer, request.user.getUsername());
        if ("yes".equals(request.message)) {
            ArrayList<Question> questionList = getQuestions();
            gui_server.matchList.add(new Match(player.user, player1.user,-1,-1,-1,-1));
            Request req1 = new Request(1);
            req1.action = "repChallenge";
            req1.questions = questionList;
            req1.message = "yes";
            req1.data[0] = player.user.getId() + "";
            req1.user = player1.user;
            //send the question for player 1
            player.oos.writeObject(req1);
            player.oos.flush();
            //send the question for player 2
            Request req2 = new Request(1);
            req2.action = "repChallenge";
            req2.questions = questionList;
            req2.message = "yes";
            req2.data[0] = player.user.getId() + "";
            req2.user = player.user;
            player1.oos.writeObject(req2);
            player1.oos.flush();
        } else {
            Request req = new Request(0);
            req.action = "repChallenge";
            req.message = "no";
            req.user = player1.user;
            player.oos.writeObject(req);
            player.oos.flush();
        }
    }
    
// sau khi chơi khi click submit thì lưu kết quả lại
    public void result(Request request, Player player1) throws IOException {
        Match match = findMatch(Integer.parseInt(request.data[0]));
        Player player2 = getPlayer(gui_server.onlinePlayer, match.getUser1().getUsername().equalsIgnoreCase(player1.user.getUsername()) ? match.getUser2().getUsername() : match.getUser1().getUsername());
        if(match.getCorrectUser1() == -1 && match.getCorrectUser2() == -1){
            if(request.user.getId() == match.getUser1().getId()){
                match.setCorrectUser1(Integer.parseInt(request.data[1]));
                match.setTimeUser1(Integer.parseInt(request.data[2]));
            }
            else{
                match.setCorrectUser2(Integer.parseInt(request.data[1]));
                match.setTimeUser2(Integer.parseInt(request.data[2]));
            }
        }
        else{
            Request req1 = new Request(0);
            Request req2 = new Request(0);
            req1.action = "result";
            req2.action = "result";
            if(match.getCorrectUser1() > -1){
                if(match.getCorrectUser1() > Integer.parseInt(request.data[1])){
                    //player1 win - player1 have correctUser1
                    if(match.getUser1().getId() == player1.getUser().getId()){
                        req1.message = "win";
                        req2.message = "lose";
                        saveResult(1, match.getCorrectUser1() + "", player1.user, player2.user);
                        saveResult(0, request.data[2], player2.user, player1.user);
                    }
                    else{
                        req1.message = "lose";
                        req2.message = "win";
                        saveResult(1, match.getCorrectUser1() + "", player2.user, player1.user);
                        saveResult(0, request.data[2], player1.user, player2.user);
                    }
                } 
                else if(match.getCorrectUser1() < Integer.parseInt(request.data[1])){
                    if(match.getUser1().getId() == player1.getUser().getId()){
                        req1.message = "lose";
                        req2.message = "win";
                        saveResult(0, match.getCorrectUser1() + "", player1.user, player2.user);
                        saveResult(1, request.data[2], player2.user, player1.user);
                    }
                    else{
                        req1.message = "win";
                        req2.message = "lose";
                        saveResult(0, match.getCorrectUser1() + "", player2.user, player1.user);
                        saveResult(1, request.data[2], player1.user, player2.user);
                    }
                }
                else{
                    req1.message = "draw";
                    req2.message = "draw";
                    if(match.getUser1().getId() == player1.getUser().getId()){
                        saveResult(0.5, match.getCorrectUser1() + "", player1.user, player2.user);
                        saveResult(0.5, request.data[2], player2.user, player1.user);
                    }
                    else{
                        saveResult(0.5, match.getCorrectUser1() + "", player2.user, player1.user);
                        saveResult(0.5, request.data[2], player1.user, player2.user);
                    }
                    
                }
            }
            else if(match.getCorrectUser2() > -1){
                 if(match.getCorrectUser2() > Integer.parseInt(request.data[1])){
                    //player1 win - player1 have correctUser1
                    if(match.getUser2().getId() == player1.getUser().getId()){
                        req1.message = "win";
                        req2.message = "lose";
                        saveResult(1, match.getCorrectUser2() + "", player1.user, player2.user);
                        saveResult(0, request.data[2], player2.user, player1.user);
                    }
                    else{
                        req1.message = "lose";
                        req2.message = "win";
                        saveResult(1, match.getCorrectUser2() + "", player2.user, player1.user);
                        saveResult(0, request.data[2], player1.user, player2.user);
                    }
                } 
                else if(match.getCorrectUser2() < Integer.parseInt(request.data[1])){
                    if(match.getUser2().getId() == player1.getUser().getId()){
                        req1.message = "lose";
                        req2.message = "win";
                        saveResult(0, match.getCorrectUser2() + "", player1.user, player2.user);
                        saveResult(1, request.data[2], player2.user, player1.user);
                    }
                    else{
                        req1.message = "win";
                        req2.message = "lose";
                        saveResult(0, match.getCorrectUser2() + "", player2.user, player1.user);
                        saveResult(1, request.data[2], player1.user, player2.user);
                    }
                }
                else{
                    req1.message = "draw";
                    req2.message = "draw";
                    if(match.getUser2().getId() == player1.getUser().getId()){
                        saveResult(0.5, match.getCorrectUser2() + "", player1.user, player2.user);
                        saveResult(0.5, request.data[2], player2.user, player1.user);
                    }
                    else{
                        saveResult(0.5, match.getCorrectUser2() + "", player2.user, player1.user);
                        saveResult(0.5, request.data[2], player1.user, player2.user);
                    }
                }
            }
            player1.oos.writeObject(req1);
            player1.oos.flush();
            player2.oos.writeObject(req2);
            player2.oos.flush();
            gui_server.matchList.remove(match);
        }
    }
    // cập nhật kết quả vào user và history
    public void saveResult(double score, String timeover, User user, User user2) {
        int win = score == 1 ? 1 : 0;
        int time = user.getTime();
        //Thắng thì thay đổi lại thời gian trung bình của lần thắng
        if (win == 1) {
            time = (user.getTime() * user.getWin() + win * Integer.parseInt(timeover)) / (user.getWin() + 1);
        }
        String state = "";
        if (score == 1){
            state = "WIN";
        }
        else if (score == 0){
            state = "LOSE";
        }
        else{
            state = "DRAW";
        }
        user.setNumOfmatches(user.getNumOfmatches() + 1);
        user.setScore(user.getScore() + score);
        user.setWin(user.getWin() + win);
        user.setTime(time);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();  
        try {
            String query = "UPDATE `users` SET `scores` = ?, `win` = ?, `matches` = ?, `time` = ? WHERE `username` = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setDouble(1, user.getScore());
                ps.setInt(2, user.getWin());
                ps.setInt(3, user.getNumOfmatches());
                ps.setInt(4, time);
                ps.setString(5, user.getUsername());
                ps.executeUpdate();
            }
            String query2 = "INSERT INTO `history` (username1, username2, state, timestamp) VALUES (?, ?, ?, ?);";
            try (PreparedStatement ps = con.prepareStatement(query2)){
                ps.setString(1, user.getUsername());
                ps.setString(2, user2.getUsername());
                ps.setString(3, state);
                ps.setString(4, formatter.format(date));
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// tìm trận đấu
    public Match findMatch(int id) {
        for (Match match : gui_server.matchList) {
            if (match.getMatchID() == id) {
                return match;
            }
        }
        return null;
    }

    public Player getPlayer(ArrayList<Player> list, String username) {
        for (Player p : list) {
            if (p.user.getUsername().equals(username)) {
                return p;
            }
        }
        return null;
    }
// lấy ra danh sách câu hỏi
    public ArrayList<Question> getQuestions() {
        String query = "SELECT * FROM `questions` ORDER BY RAND() LIMIT 15";
        ResultSet result;
        ArrayList<Question> list = new ArrayList<>();
        Question question;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            result = ps.executeQuery();
            while (result.next()) {
                question = createQuestion(result);
                list.add(question);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<History> getHistorys(String username){
        String query = "SELECT * FROM `history` WHERE username1 = ? ORDER BY id";
        ResultSet result;
        ArrayList<History> list = new ArrayList<>();
        History history;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            result = ps.executeQuery();
            while (result.next()) {
                history = createHistory(result);
                list.add(history);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
// tạo đối tượng câu hỏi để đẩy vào list
    public Question createQuestion(ResultSet result) throws SQLException {
        Question q = new Question();
        q.setId(result.getInt("id"));
        q.setContent(result.getString("content"));
        q.setAnswer1(result.getString("answer1"));
        q.setAnswer2(result.getString("answer2"));
        q.setAnswer3(result.getString("answer3"));
        q.setAnswer4(result.getString("answer4"));
        q.setKey(result.getString("key"));

        return q;
    }

    public History createHistory(ResultSet result) throws SQLException {
        History h = new History();
        h.setId(result.getInt("id"));
        h.setUserNN1(result.getString("username1"));
        h.setUserNN2(result.getString("username2"));
        h.setState(result.getString("state"));
        h.setTimestamp(result.getString("timestamp"));
        return h;
    }
    
// cập nhât trạng thái của player
    public void updateStatus(Player player, String status) throws IOException {
        for (int i = 0; i < gui_server.onlineList.size(); i++) {
            if (gui_server.onlineList.get(i).getUsername().equals(player.user.getUsername())) {
                gui_server.onlineList.get(i).setStatus("busy".equalsIgnoreCase(status) ? 0 : 1);
                gui_server.onlinePlayer.get(i).setStatus("busy".equalsIgnoreCase(status) ? 0 : 1);
            }
            else sendOnlineList(gui_server.onlinePlayer.get(i).oos, gui_server.onlineList);
        }
        sendOnlineList(player.oos, gui_server.onlineList);
    }
}
