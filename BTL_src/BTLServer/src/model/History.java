/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author APC-LTN
 */
public class History implements Serializable{
    private static final long serialVersionUID = 3L;
    private int id;
    private String userNN1;
    private String userNN2;
    private String state;
    private String timestamp;

    public History() {
    }

    public History(int id, String userNN1, String userNN2, String state, String timestamp) {
        this.id = id;
        this.userNN1 = userNN1;
        this.userNN2 = userNN2;
        this.state = state;
        this.timestamp = timestamp;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserNN1() {
        return userNN1;
    }

    public void setUserNN1(String userNN1) {
        this.userNN1 = userNN1;
    }

    public String getUserNN2() {
        return userNN2;
    }

    public void setUserNN2(String userNN2) {
        this.userNN2 = userNN2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
}
