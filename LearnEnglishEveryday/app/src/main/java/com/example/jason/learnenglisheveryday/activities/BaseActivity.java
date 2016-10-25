package com.example.jason.learnenglisheveryday.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Helpers;
import com.example.jason.learnenglisheveryday.Utils.Utils;

import butterknife.ButterKnife;

/**
 * Created by jason on 19/10/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Context context;
    protected Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        activity = this;
    }


    protected void setStartActivityAnimation() {
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    protected void setBackAnimation() {
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

}
