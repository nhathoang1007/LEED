package com.example.jason.learnenglisheveryday.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jason.learnenglisheveryday.MesageDialogs.JsAlertDialog;
import com.example.jason.learnenglisheveryday.MesageDialogs.JsProgressDialog;
import com.example.jason.learnenglisheveryday.R;

/**
 * Created by jason on 21/10/2016.
 */
public class Utils {

    /**
     * Utils
     */
    private static Utils mUtils;

    /**
     * Define Progress Dialog
     */
    private JsProgressDialog progressDialog;

    /**
     *
     * @return Utils
     */
    public static Utils getInstance() {
        if(mUtils == null)
            mUtils = new Utils();
        return mUtils;
    }

    /**
     * Show Progress Dialog
     * @param activity
     */
    public void showProgressDialog(Activity activity){
        progressDialog = new JsProgressDialog(activity);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    /**
     * Dismiss Progress Dialog
     */
    public void dismissProgressDialog(){
        progressDialog.dismiss();
    }

    /**
     * Show Dialog Message ReLogin
     * @param activity
     */
    public void showReLoginDialog(final Activity activity){
        JsAlertDialog mAlertDialog = new JsAlertDialog(activity);
        mAlertDialog.setTitle(activity.getString(R.string.re_login_alert_title));
        mAlertDialog.setMessage(activity.getString(R.string.re_login_alert_message));
        mAlertDialog.setHasCancel(false);
        mAlertDialog.setNegative(activity.getString(R.string.back_to_login));
        mAlertDialog.setNegativeListener(new JsAlertDialog.OnSetNegativeListener() {
            @Override
            public void setNegative(DialogInterface dialogInterface) {
                dialogInterface.cancel();
                Toast.makeText(activity.getApplicationContext(), "OK", Toast.LENGTH_SHORT).show();
            }
        });
        mAlertDialog.Builder();
    }

    /**
     * Set Typeface for TextView
     * @param textView
     * @param context
     */
    public void setTypeface(TextView textView, Context context){
        Typeface titleFont = Typeface.createFromAsset(context.getAssets(), "ProximaNova-Regular.ttf");
        textView.setTypeface(titleFont);
    }
    /**
     * Set Typeface for TextView
     * @param toolbar
     * @param context
     */
    public void setToolbarTypeface(Toolbar toolbar, Context context){
        Typeface titleFont = Typeface.createFromAsset(context.getAssets(), "ProximaNova-Regular.ttf");
        for(int i = 0; i < toolbar.getChildCount(); i++){
            View view = toolbar.getChildAt(i);
            if(view instanceof TextView){
                TextView tv = (TextView) view;
                tv.setTypeface(titleFont);
                break;
            }
        }
    }

    /**
     * Show SnackBar Message
     * @param context
     * @param view
     * @param content
     */
    public void showSnackBar(Context context, View view, String content){
        Snackbar snack = Snackbar.make(view, content, Snackbar.LENGTH_SHORT);
        View snackView = snack.getView();
        TextView tv = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
        snackView.setBackgroundResource(R.color.white);
        tv.setTextColor(Color.RED);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN) {
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        }
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        setTypeface(tv, context);

        snack.show();
    }
}
