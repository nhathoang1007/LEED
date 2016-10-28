package com.example.jason.learnenglisheveryday.activities.Start;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;
import com.example.jason.learnenglisheveryday.activities.Home.HomeActivity;
import com.example.jason.learnenglisheveryday.activities.Login.LoginActivity;
import com.example.jason.learnenglisheveryday.activities.Register.RegisterActivity;
import com.example.jason.learnenglisheveryday.localStogares.JSPreferenceManager;
import com.example.jason.learnenglisheveryday.localStogares.LoginPreference;
import com.pnikosis.materialishprogress.ProgressWheel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jason on 26/10/2016.
 */
public class StartMainActivity extends BaseActivity implements IStartMainView {

    @BindView(R.id.login_bottom)
    LinearLayout loginBottom;

    @BindView(R.id.progress_wheel_portrait)
    ProgressWheel progressWheelPortrait;

    @BindView(R.id.progress_wheel_landscape)
    ProgressWheel progressWheelLandscape;

    public static final int IN_HOME = 1;
    public static final int IN_LOGIN_MAIN = 2;
    private IStartMainPresenter mStartMainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        mStartMainPresenter = new StartMainPresenter(this);
        showProgressWheel();
        mStartMainPresenter.checkSUsingLastView(context);
    }

    @OnClick(R.id.button_login)
    public void gotoLogin(){
        startActivity(new Intent(activity, LoginActivity.class));
        setStartActivityAnimation();
    }

    @OnClick(R.id.button_register)
    public void gotoRegister(){
        startActivity(new Intent(activity, RegisterActivity.class));
        setStartActivityAnimation();
    }

    @OnClick(R.id.button_skip)
    public void gotoHome(){
        JSPreferenceManager.getInstance().getLoginPreference(context).setLogin(LoginPreference.STATUS_LOGOUT);
        startActivity(new Intent(activity, HomeActivity.class));
        setStartActivityAnimation();
    }

    @Override
    public void showLastView(int status) {
        stopProgressWheel();
        switch (status){
            case IN_HOME:
                startActivity(new Intent(activity, HomeActivity.class));
                setStartActivityAnimation();
                break;
            case IN_LOGIN_MAIN:
                loginBottom.animate().alpha(1.f).setDuration(1000);
                break;
            default: break;
        }
    }

    public void showProgressWheel() {
        Log.e("ProgressWheel", "show");
        try {
            showCallbackProgressWheel(progressWheelLandscape);
            showCallbackProgressWheel(progressWheelPortrait);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showCallbackProgressWheel(ProgressWheel progressWheel){
        progressWheel.setCallback(new ProgressWheel.ProgressCallback() {
            @Override
            public void onProgressUpdate(float progress) {
                if (progress == 0) {
                    progressWheelLandscape.setProgress(1.0f);
                } else if (progress == 1.0f) {
                    progressWheelLandscape.setProgress(0.0f);
                }
            }
        });
    }

    public void stopProgressWheel() {
        try {
            progressWheelPortrait.stopSpinning();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                progressWheelLandscape.stopSpinning();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
