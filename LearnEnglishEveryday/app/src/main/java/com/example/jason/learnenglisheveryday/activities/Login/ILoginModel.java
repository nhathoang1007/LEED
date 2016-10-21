package com.example.jason.learnenglisheveryday.activities.Login;

import android.content.Context;

/**
 * Created by jason on 21/10/2016.
 */
public interface ILoginModel {
    interface LoginListener{
        void onLoginSuccess();
        void onInValid(String message);
        void onLoginFail(int status);
    }

    void checkAccount(Context context, String email, String password, LoginListener listener);
}
