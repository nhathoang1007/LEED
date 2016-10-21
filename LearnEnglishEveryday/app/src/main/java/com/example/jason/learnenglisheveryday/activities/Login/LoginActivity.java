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
import com.example.jason.learnenglisheveryday.activities.SignUp.SignUpActivity;

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


    @BindView(R.id.layout_root)
    LinearLayout viewRoot;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Helpers.setFullScreen(this);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        mLoginPresenter = new LoginPresenter(this);
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.button_normalLogIn)
    public void loginNormal(){
        mLoginPresenter.checkAccount(context, Helpers.getString(edtEmail), Helpers.getString(edtPassword));
    }

    @OnClick(R.id.button_createNewAccount)
    public void createNewAccount(){
        startActivity(new Intent(this, SignUpActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
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

    }

    @Override
    public void loginFail(int status) {
        Utils.getInstance().showReLoginDialog(LoginActivity.this);
    }
}
