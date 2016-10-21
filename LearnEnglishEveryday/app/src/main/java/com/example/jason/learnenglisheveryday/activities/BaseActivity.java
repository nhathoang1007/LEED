package com.example.jason.learnenglisheveryday.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Helpers;
import com.example.jason.learnenglisheveryday.Utils.Utils;

import butterknife.ButterKnife;

/**
 * Created by jason on 19/10/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        initView();
    }

    protected abstract void initView();

}
