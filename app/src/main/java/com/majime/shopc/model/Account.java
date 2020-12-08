package com.majime.shopc.model;

public abstract class Account {
    private String username, password;

    public Account() {
        this.username = "Admin";
        this.password = "Admin";
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
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

}
