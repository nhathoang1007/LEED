package com.example.jason.learnenglisheveryday.APIs;

import com.example.jason.learnenglisheveryday.Utils.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jason on 21/10/2016.
 */
public class RetrofitManager {

    private APIs apIs;
    private Retrofit mRetrofit;

    public RetrofitManager(int timeOut) {
        setUpRetrofit(timeOut);
    }

    public void setUpRetrofit(int timeOut){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.SERVER)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public APIs getApIs(){
        if (apIs == null){
            apIs = mRetrofit.create(APIs.class);
        } return apIs;
    }
}
