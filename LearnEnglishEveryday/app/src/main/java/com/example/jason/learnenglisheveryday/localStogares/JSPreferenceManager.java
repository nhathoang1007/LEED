package com.example.jason.learnenglisheveryday.localStogares;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.jason.learnenglisheveryday.entities.Account;

/**
 * Created by jason on 24/10/2016.
 */
public class JSPreferenceManager {

    private static LoginPreference mLoginPreference;
    private static JSPreferenceManager mJsSharedPreference;

    public static synchronized JSPreferenceManager getInstance(){
        if (mJsSharedPreference == null){
            mJsSharedPreference = new JSPreferenceManager();
        }
        return mJsSharedPreference;
    }

    public LoginPreference getLoginPreference(Context context) {
        if (mLoginPreference == null){
            mLoginPreference = new LoginPreference(context);
        }
       return mLoginPreference;
    }
}
