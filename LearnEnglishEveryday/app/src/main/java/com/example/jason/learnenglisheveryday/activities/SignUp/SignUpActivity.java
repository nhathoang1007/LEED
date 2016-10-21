package com.example.jason.learnenglisheveryday.activities.SignUp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 21/10/2016.
 */
public class SignUpActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        setupToolbar();

    }

    public void setupToolbar(){
        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.drawable.arrow_left);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }
//        });
//        Utils.getInstance().setToolbarTypeface(toolbar, this);
    }
}
