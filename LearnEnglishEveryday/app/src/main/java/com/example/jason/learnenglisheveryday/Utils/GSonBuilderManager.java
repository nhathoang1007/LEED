package com.example.jason.learnenglisheveryday.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Response;

/**
 * Created by jason on 21/10/2016.
 */
public class GSonBuilderManager {
    private static GSonBuilderManager mGSonManager;
    private Gson mGSon;

    private GSonBuilderManager() {
        mGSon = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
    }

    public static GSonBuilderManager getInstance() {
        if(mGSonManager == null)
            mGSonManager = new GSonBuilderManager();
        return mGSonManager;
    }

    public Gson getGSon() {
        return mGSon;
    }

    public JSONObject getJSONObject(Response response){
        String content = mGSonManager.getGSon().toJson(response.body());
        JSONObject mJsonObject = null;
        if (content != null) {
            try {
                mJsonObject = new JSONObject(content);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return mJsonObject;
    }
}
