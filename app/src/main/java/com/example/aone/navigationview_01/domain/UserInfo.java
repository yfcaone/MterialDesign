package com.example.aone.navigationview_01.domain;

/**
 * Created by aone on 2016/7/28.
 */
public class UserInfo {

    private int id;
    private String username;
    private String password;

    public UserInfo(int id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
