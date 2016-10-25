package com.example.jason.learnenglisheveryday.activities.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Constants;
import com.example.jason.learnenglisheveryday.Utils.Helpers;
import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;
import com.example.jason.learnenglisheveryday.activities.Home.HomeActivity;
import com.example.jason.learnenglisheveryday.activities.SignUp.SignUpActivity;
import com.example.jason.learnenglisheveryday.localStogares.JSSharedPreference;
import com.example.jason.learnenglisheveryday.localStogares.PreferenceConstants;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jason on 19/10/2016.
 */
public class LoginActivity extends BaseActivity implements ILoginView {

    @BindView(R.id.editText_username)
    EditText edtEmail;

    @BindView(R.id.editText_password)
    EditText edtPassword;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Helpers.setFullScreen(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mLoginPresenter = new LoginPresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.layout_root)
    public void hideKeyBoard(){
        Utils.getInstance().hideKeyBoard(activity);
    }

    @OnClick(R.id.button_normalLogIn)
    public void loginNormal(){
        Utils.getInstance().hideKeyBoard(activity);
        mLoginPresenter.checkAccount(context, Helpers.getString(edtEmail), Helpers.getString(edtPassword));
    }

    @OnClick(R.id.button_createNewAccount)
    public void createNewAccount(){
        startActivity(new Intent(this, SignUpActivity.class));
        setStartActivityAnimation();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public View getView() {
        return edtEmail;
    }

    @Override
    public void loginSuccess() {
        new JSSharedPreference(PreferenceConstants.LOGIN_PRE_NAME, this).saveAccountInformation( Helpers.getString(edtEmail), Helpers.getString(edtPassword), true);
    }

    @Override
    public void loginFail(int status) {
        startActivity(new Intent(activity, HomeActivity.class));
        setStartActivityAnimation();
//        Utils.getInstance().showReLoginDialog(LoginActivity.this);
    }
}
