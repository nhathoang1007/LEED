package com.example.jason.learnenglisheveryday.MesageDialogs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by jason on 21/10/2016.
 */
public class JsProgressDialog {

    private Activity activity;
    private String message;
    private boolean cancelable;
    private ProgressDialog progressDialog;


    public JsProgressDialog(Activity activity) {
        this.activity = activity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }

    public void show() {

        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(cancelable);
        progressDialog.show();
    }

    public void dismiss(){
        try {
            progressDialog.dismiss();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
