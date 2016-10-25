package com.example.jason.learnenglisheveryday.APIs;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by jason on 21/10/2016.
 */
public interface APIs {
    //Check sign_in
    @POST("user/client/login")
    Call<JsonObject> gotoLogIn(@Body JsonObject account);

    //Check sign_up
    @POST("user/client/sign_up")
    Call<JsonObject> gotoSignUp(@Body JsonObject account);
}
