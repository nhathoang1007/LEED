package com.example.jason.learnenglisheveryday.localStogares;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.jason.learnenglisheveryday.entities.Account;

/**
 * Created by jason on 26/10/2016.
 */
public class LoginPreference {

    private SharedPreferences mSharedPreferences;
    public static final boolean STATUS_LOGOUT = false;
    public static final boolean STATUS_LOGIN = true;

    public LoginPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(PreferenceConstants.LOGIN_PRE_NAME, 1);
    }
    //---------------------------- LOGIN SHARE PREFERENCE --------------------------------------------------
    /**
     * save account information
     * @param email
     * @param password
     */
    public void saveAccountInformation(String email, String password){
        SharedPreferences.Editor e = mSharedPreferences.edit();
        e.putString(PreferenceConstants.LOGIN_EMAIL, email);
        e.putString(PreferenceConstants.LOGIN_PASSWORD, password);
        e.putBoolean(PreferenceConstants.LOGIN_STATUS, STATUS_LOGIN);
        e.commit();
    }

    /**
     * get account information
     * @return
     */
    public Account getAccount(){
        String email = mSharedPreferences.getString(PreferenceConstants.LOGIN_EMAIL, null);
        String password = mSharedPreferences.getString(PreferenceConstants.LOGIN_PASSWORD, null);
        boolean isLogin = mSharedPreferences.getBoolean(PreferenceConstants.LOGIN_STATUS, STATUS_LOGOUT);
        return new Account(email, password, isLogin);
    }

    /**
     * set login status
     */
    public void setLogin(boolean status){
        SharedPreferences.Editor e = mSharedPreferences.edit();
        e.putBoolean(PreferenceConstants.LOGIN_STATUS, status);
        e.commit();
    }

    /**
     * login status
     * @return
     */
    public boolean isLogin(){
        return mSharedPreferences.getBoolean(PreferenceConstants.LOGIN_STATUS, false);
    }


    //---------------------------- USER PROFILE SHARE PREFERENCE --------------------------------------------------



    //---------------------------- SHARE PREFERENCE CLEAR DATA-----------------------------------------------------
    /**
     * Clear login data
     */
    public void clear(){
        SharedPreferences.Editor e = mSharedPreferences.edit();
        e.clear();
    }

}
