/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nguye
 */
public class Match {

    private User user1;
    private User user2;
    private String[] text1 = new String[]{"", ""};
    private String[] text2 = new String[]{"", ""};
    private int matchID;
    private int correctUser1;
    private int correctUser2;
    private int timeUser1;
    private int timeUser2;

    public Match(User user1, User user2,int correctUser1,int correctUser2,int timeUser1,int timeUser2) {
        this.user1 = user1;
        this.user2 = user2;
        this.matchID = user1.getId();
        this.correctUser1 = correctUser1;
        this.correctUser2 = correctUser2;
        this.timeUser1 = timeUser1;
        this.timeUser2 = timeUser2;
    }

    public String[] getText1() {
        return text1;
    }

    public void setText1(String[] text1) {
        this.text1 = text1;
    }

    public String[] getText2() {
        return text2;
    }

    public void setText2(String[] text2) {
        this.text2 = text2;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public int getMatchID() {
        return matchID;
    }

    public void setMatchID(int matchID) {
        this.matchID = matchID;
    }

    public int getCorrectUser1() {
        return correctUser1;
    }

    public void setCorrectUser1(int correctUser1) {
        this.correctUser1 = correctUser1;
    }

    public int getCorrectUser2() {
        return correctUser2;
    }

    public void setCorrectUser2(int correctUser2) {
        this.correctUser2 = correctUser2;
    }

    public int getTimeUser1() {
        return timeUser1;
    }

    public void setTimeUser1(int timeUser1) {
        this.timeUser1 = timeUser1;
    }

    public int getTimeUser2() {
        return timeUser2;
    }

    public void setTimeUser2(int timeUser2) {
        this.timeUser2 = timeUser2;
    }
    

}
