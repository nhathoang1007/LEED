package com.example.jason.learnenglisheveryday.activities.Login;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by jason on 21/10/2016.
 */
public interface ILoginView {
    Activity getActivity();
    View getView();
    void loginSuccess();
    void loginFail(int status);
}
