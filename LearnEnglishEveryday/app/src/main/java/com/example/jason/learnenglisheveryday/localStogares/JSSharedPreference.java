package com.example.jason.learnenglisheveryday.localStogares;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.jason.learnenglisheveryday.Utils.Constants;
import com.example.jason.learnenglisheveryday.entities.Account;

/**
 * Created by jason on 24/10/2016.
 */
public class JSSharedPreference {

    private SharedPreferences mSharedPreference;

    public JSSharedPreference(String PRE_NAME, Context context) {
        mSharedPreference = context.getSharedPreferences(PRE_NAME, Constants.PRE_MODE);
    }


    //---------------------------- LOGIN SHARE PREFERENCE --------------------------------------------------
    /**
     * save account information
     * @param email
     * @param password
     * @param isLogin
     */
    public void saveAccountInformation(String email, String password, boolean isLogin){
        SharedPreferences.Editor e = mSharedPreference.edit();
        e.putString(PreferenceConstants.LOGIN_EMAIL, email);
        e.putString(PreferenceConstants.LOGIN_PASSWORD, password);
        e.putBoolean(PreferenceConstants.LOGIN_STATUS, isLogin);
        e.commit();
    }

    /**
     * get account information
     * @return
     */
    public Account getAccount(){
        String email = mSharedPreference.getString(PreferenceConstants.LOGIN_EMAIL, null);
        String password = mSharedPreference.getString(PreferenceConstants.LOGIN_PASSWORD, null);
        boolean isLogin = mSharedPreference.getBoolean(PreferenceConstants.LOGIN_STATUS, false);
        return new Account(email, password, isLogin);
    }

    /**
     * set login status
     */
    public void setLogin(){
        SharedPreferences.Editor e = mSharedPreference.edit();
        e.putBoolean(PreferenceConstants.LOGIN_STATUS, true);
        e.commit();
    }

    /**
     * set logout status
     */
    public void setLogout(){
        SharedPreferences.Editor e = mSharedPreference.edit();
        e.putBoolean(PreferenceConstants.LOGIN_STATUS, false);
        e.commit();
    }


    //---------------------------- USER PROFILE SHARE PREFERENCE --------------------------------------------------






    //---------------------------- SHARE PREFERENCE CLEAR DATA--------------------------------------------------
    /**
     * Clear login data
     */
    public void clear(){
        SharedPreferences.Editor e = mSharedPreference.edit();
        e.clear();
    }

}
