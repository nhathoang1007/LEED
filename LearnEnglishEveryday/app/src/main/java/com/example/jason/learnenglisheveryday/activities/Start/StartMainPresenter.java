package com.example.jason.learnenglisheveryday.activities.Start;

import android.content.Context;
import android.os.Handler;
import com.example.jason.learnenglisheveryday.localStogares.JSPreferenceManager;

/**
 * Created by jason on 26/10/2016.
 */
public class StartMainPresenter implements IStartMainPresenter{

    private IStartMainView mView;

    public StartMainPresenter(IStartMainView mView) {
        this.mView = mView;
    }

    @Override
    public void checkSUsingLastView(final Context context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (JSPreferenceManager.getInstance().getLoginPreference(context).isLogin()){
                    mView.showLastView(StartMainActivity.IN_HOME);
                } else {
                    mView.showLastView(StartMainActivity.IN_LOGIN_MAIN);
                }
            }
        }, 5000);
    }
}
