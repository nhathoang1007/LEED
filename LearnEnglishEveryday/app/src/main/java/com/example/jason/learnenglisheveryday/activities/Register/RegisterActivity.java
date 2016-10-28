package com.example.jason.learnenglisheveryday.activities.Register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Constants;
import com.example.jason.learnenglisheveryday.Utils.Helpers;
import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;
import com.example.jason.learnenglisheveryday.activities.Login.ILoginPresenter;
import com.example.jason.learnenglisheveryday.activities.Login.ILoginView;
import com.example.jason.learnenglisheveryday.activities.Vocabulary.VocabularyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jason on 21/10/2016.
 */
public class RegisterActivity extends BaseActivity implements ILoginView{

    @BindView(R.id.editText_username)
    EditText edtEmail;

    @BindView(R.id.editText_password)
    EditText edtPassword;

    @BindView(R.id.editText_confirm_password)
    EditText edtConfirmPassword;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        setupToolbar();
        mLoginPresenter = new RegisterPresenter(this);
    }

    public void setupToolbar(){
        Utils.getInstance().setupToolbar(activity, toolbar, R.string.sign_up_title, R.drawable.icon_arrow_left);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @OnClick(R.id.button_sign_up)
    public void createAccount(){
        Utils.getInstance().hideKeyBoard(activity);
        if (Helpers.isNetworkAvailable(context)){
            if (Helpers.getString(edtConfirmPassword).matches(Helpers.getString(edtPassword))){
                mLoginPresenter.checkAccount(context, Helpers.getString(edtEmail), Helpers.getString(edtPassword));
            } else {
                Utils.getInstance().showSnackBar(context, toolbar, "Password does't match. Please check and try again");
            }
        } else {
            Utils.getInstance().showSnackBar(context, toolbar, "This feature requires internet connection");
        }
    }

    @Override
    public Activity getActivity() {
        return activity;
    }

    @Override
    public View getView() {
        return toolbar;
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(activity, VocabularyActivity.class));
        setStartActivityAnimation();
        finish();
    }

    @Override
    public void loginFail(int status) {
        switch (status){
            case Constants.RETROFIT_RESPONSE_SUCCESS_1:
                Utils.getInstance().showSnackBar(context, toolbar, "The login credentials you provided are not valid");
                break;
            case Constants.RETROFIT_RESPONSE_SUCCESS_3:
                Utils.getInstance().showSnackBar(context, toolbar, "The login credentials you provided are not valid");
                break;
            case Constants.RETROFIT_RESPONSE_SUCCESS_4:
                Utils.getInstance().showSnackBar(context, toolbar, "The login credentials you provided are not valid");
                break;
            default: break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setBackAnimation();
    }
}
