package com.example.jason.learnenglisheveryday.MesageDialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by jason on 21/10/2016.
 */
public class JsAlertDialog{

    private Activity activity;
    private AlertDialog mAlertDialog;
    private AlertDialog.Builder mBuilder;
    private OnSetPositiveListener onSetPositive;
    private OnSetNegativeListener onSetNegative;
    private String title = null;
    private String message = null;
    private boolean isHasCancel = false;
    private boolean isHasPositive = false;
    private String positive = null;
    private String negative;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public JsAlertDialog(Activity activity) {
        this.activity = activity;
    }

    public void setHasCancel(boolean hasCancel) {
        isHasCancel = hasCancel;
    }

    public void setHasPositive(boolean hasPositive) {
        isHasPositive = hasPositive;
    }

    public void setPositiveListener(OnSetPositiveListener onSetPositive){
        this.onSetPositive = onSetPositive;
    }


    public void setNegativeListener(OnSetNegativeListener onSetNegative){
        this.onSetNegative = onSetNegative;
    }

    public void Builder() {
        mBuilder = new AlertDialog.Builder(activity);

        if (title != null) {
            mBuilder.setTitle(title);
        }

        mBuilder.setCancelable(isHasCancel);

        mBuilder.setMessage(message);

        if (positive != null) {
            mBuilder.setPositiveButton(positive, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // TO DO
                    cancelAlertDialog();
                    onSetPositive.setPositive();
                }
            });
        }

        mBuilder.setNegativeButton(negative, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // TO DO
                        onSetNegative.setNegative(dialog);
                    }
        });
        mAlertDialog = mBuilder.create();
        mAlertDialog.show();
    }

    public void cancelAlertDialog(){
        try {
            mAlertDialog.cancel();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public interface OnSetPositiveListener {
        void setPositive();
    }

    public interface OnSetNegativeListener {
        void setNegative(DialogInterface dialogInterface);
    }

}
