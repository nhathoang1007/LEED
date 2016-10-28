package com.example.jason.learnenglisheveryday.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jason.learnenglisheveryday.R;

/**
 * Created by jason on 24/10/2016.
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;
    protected Activity activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.context = getContext();
        this.activity = getActivity();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void setToolbarTitle(String title){
        ((AppCompatActivity) activity).getSupportActionBar().setTitle(title);
    }

    protected void setStartActivityAnimation() {
        activity.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    protected void setBackAnimation() {
        activity.overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

}
