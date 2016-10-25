package com.example.jason.learnenglisheveryday.entities;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jason on 24/10/2016.
 */
public class Account {

    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("password")
    @Expose
    private String password;

    private boolean isLogin;

    public String asJson() {
        return new Gson().toJson(this);
    }

    public Account convertFromJson(String json) {
        return new Gson().fromJson(json, Account.class);
    }

    public Account(String email, String password, boolean isLogin) {
        this.email = email;
        email = password;
        this.isLogin = isLogin;
    }

    public Account(String email, String password) {
        this.email = email;
        email = password;
    }

    public Account() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
