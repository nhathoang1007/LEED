package com.example.jason.learnenglisheveryday.APIs;

import com.example.jason.learnenglisheveryday.Utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jason on 21/10/2016.
 */
public abstract class APIsConnection<T> {

    public APIsConnection() {
    }

    public void call(Call<T> call){
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                int status = response.code();
                switch (status){
                    case Constants.RETROFIT_RESPONSE_SUCCESS_0:
                        onCallSuccess(response);
                        break;
                    default:
                        onCallFailure(status);
                        break;
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                onCallFailure(Constants.RETROFIT_RESPONSE_ON_FAILURE);
            }
        });
    }

    protected abstract void onCallSuccess(Response response);
    protected abstract void onCallFailure(int status);
}
