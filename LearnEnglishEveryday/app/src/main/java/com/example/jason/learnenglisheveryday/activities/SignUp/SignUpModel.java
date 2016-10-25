package com.example.jason.learnenglisheveryday.activities.SignUp;

import android.content.Context;

import com.example.jason.learnenglisheveryday.APIs.APIsConnection;
import com.example.jason.learnenglisheveryday.APIs.RetrofitManager;
import com.example.jason.learnenglisheveryday.Utils.Helpers;
import com.example.jason.learnenglisheveryday.activities.Login.ILoginModel;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by jason on 25/10/2016.
 */
public class SignUpModel implements ILoginModel {
    @Override
    public void checkAccount(Context context, String email, String password, final LoginListener listener) {
        List<String> strings = new ArrayList<>();
        strings.add(email);
        strings.add(password);
        if (Helpers.isEmpty(strings)){
            listener.onInValid("Input is empty");
        } else if (!Helpers.isEmailValid(email)) {
            listener.onInValid("Email doesn't match ");
        } else {
            if (Helpers.isNetworkAvailable(context)){
                callCheckAccount(context, parseAccount(email, password), listener);
            } else {
                listener.onInValid("Can't find network");
            }
        }
    }

    private void callCheckAccount(final Context context, JsonObject jsonObject, final LoginListener listener){
        RetrofitManager mRetrofitManage = new RetrofitManager(60);
        Call<JsonObject> call = mRetrofitManage.getApIs().gotoSignUp(jsonObject);
        new APIsConnection<JsonObject>() {
            @Override
            protected void onCallSuccess(Response response) {
                listener.onLoginSuccess();
            }

            @Override
            protected void onCallFailure(int status) {
                listener.onLoginFail(status);
            }
        }.call(call);
    }

    private JsonObject parseAccount(String email, String password){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("password", password);
        return jsonObject;
    }
}
