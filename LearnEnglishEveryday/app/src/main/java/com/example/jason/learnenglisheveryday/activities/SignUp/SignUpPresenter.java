package com.example.jason.learnenglisheveryday.activities.SignUp;

import android.content.Context;

import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.Login.ILoginModel;
import com.example.jason.learnenglisheveryday.activities.Login.ILoginPresenter;
import com.example.jason.learnenglisheveryday.activities.Login.ILoginView;
import com.example.jason.learnenglisheveryday.activities.Login.LoginModel;

/**
 * Created by jason on 25/10/2016.
 */
public class SignUpPresenter implements ILoginPresenter, ILoginModel.LoginListener {

    private ILoginView mView;
    private ILoginModel mLoginModel;

    public SignUpPresenter(ILoginView mView) {
        this.mView = mView;
        mLoginModel = new SignUpModel();
    }

    @Override
    public void checkAccount(Context context, String email, String password) {
        Utils.getInstance().showProgressDialog(mView.getActivity());
        mLoginModel.checkAccount(context, email, password, this);
    }

    @Override
    public void onLoginSuccess() {
        Utils.getInstance().dismissProgressDialog();
        mView.loginSuccess();
    }

    @Override
    public void onInValid(String message) {
        Utils.getInstance().dismissProgressDialog();
        Utils.getInstance().showSnackBar(mView.getActivity().getApplicationContext(), mView.getView(), message);
    }

    @Override
    public void onLoginFail(int status) {
        Utils.getInstance().dismissProgressDialog();
        mView.loginFail(status);
    }
}
