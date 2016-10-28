package com.example.jason.learnenglisheveryday.activities.Login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Helpers;
import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;
import com.example.jason.learnenglisheveryday.activities.Home.HomeActivity;
import com.example.jason.learnenglisheveryday.activities.Register.RegisterActivity;
import com.example.jason.learnenglisheveryday.localStogares.JSPreferenceManager;

import butterknife.BindView;
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
        startActivity(new Intent(this, RegisterActivity.class));
        setStartActivityAnimation();
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
        JSPreferenceManager.getInstance().getLoginPreference(context).saveAccountInformation(Helpers.getString(edtEmail), Helpers.getString(edtPassword));
    }

    @Override
    public void loginFail(int status) {
        JSPreferenceManager.getInstance().getLoginPreference(context).saveAccountInformation(Helpers.getString(edtEmail), Helpers.getString(edtPassword));
        startActivity(new Intent(activity, HomeActivity.class));
        setStartActivityAnimation();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setBackAnimation();
    }
}
