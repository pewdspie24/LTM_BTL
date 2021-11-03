/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class Request implements Serializable {
    
    public String action = null; 
    public String[] data;
    public ArrayList<String[]> data_arr;
    public ArrayList<Player> players;
    public ArrayList<User> onlineList;
    public ArrayList<User> rank;
    public ArrayList<Question> questions;
    public User user;
    public String message;
    
    public Request(int length){
        this.data = new String[length];
    }
    public Request(String action,String[] data, ArrayList<String[]> data_arr) {
        this.action = action;
        this.data = data;
        this.data_arr = data_arr;
    }
    
}
