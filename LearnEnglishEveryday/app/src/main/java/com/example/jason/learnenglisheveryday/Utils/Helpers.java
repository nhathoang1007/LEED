package com.example.jason.learnenglisheveryday.Utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.jason.learnenglisheveryday.R;

import java.util.List;

/**
 * Created by jason on 21/10/2016.
 */
public class Helpers {


    /**
     * check connecting to network
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        Log.e("NetworkAvailable","Doing");
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    /**
     * Check list string empty
     * @param contents
     * @return
     */
    public static boolean isEmpty(List<String> contents){
        boolean result = false;
        for (String content: contents) {
            if (content.equals(Constants.EMPTY_STRING)) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * check matching between two string
     * @param content_1
     * @param content_2
     * @return
     */
    public static boolean isMatched(String content_1, String content_2){
        return content_1.matches(content_2);
    }

    /**
     * getString from editText
     * @param editText
     * @return
     */
    public static String getString(EditText editText){
        return editText.getText().toString().trim();
    }

    /**
     * Check invalid email format
     * @param email
     * @return
     */
    public static boolean isEmailValid(String email){
        boolean emailValid = true;
        if (!email.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+[a-zA-Z0-9]+\\.[a-zA-Z0-9]+")) {
            if (!email.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+[a-zA-Z0-9]+")) {
                emailValid = false;
            }
        }
        if (email.substring(0, 1).matches("[._-]")) {
            emailValid = false;
        }
        if (email.contains("..")) {
            emailValid = false;
        }
        if (email.contains(".@")) {
            emailValid = false;
        }
        return emailValid;
    }

    /**
     *
     * @param activity
     */
    public static void setFullScreen(Activity activity){
        try {
            activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            activity.setContentView(R.layout.activity_login);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
