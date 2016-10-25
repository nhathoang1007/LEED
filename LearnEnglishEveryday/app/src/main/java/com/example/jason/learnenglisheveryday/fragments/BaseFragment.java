package com.example.jason.learnenglisheveryday.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
}
