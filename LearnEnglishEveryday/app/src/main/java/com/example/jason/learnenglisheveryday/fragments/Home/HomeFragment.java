package com.example.jason.learnenglisheveryday.fragments.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.customs.CustomFunctionsLayout;
import com.example.jason.learnenglisheveryday.fragments.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 25/10/2016.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.function_1)
    CustomFunctionsLayout functionsLayout_1;

    @BindView(R.id.function_2)
    CustomFunctionsLayout functionsLayout_2;

    @BindView(R.id.function_3)
    CustomFunctionsLayout functionsLayout_3;

    @BindView(R.id.function_4)
    CustomFunctionsLayout functionsLayout_4;

    private String[] titles = {"Vocabulary", "Listening", "Speaking", "Testing"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        setToolbarTitle("Home");
        setFunctionClick(functionsLayout_1, 1);
        setFunctionClick(functionsLayout_2, 2);
        setFunctionClick(functionsLayout_3, 3);
        setFunctionClick(functionsLayout_4, 4);
        setFunctionRate();
        setFunctionTitle(titles);
        return view;
    }


    private void setFunctionClick(CustomFunctionsLayout functionsLayout, final int position){
        functionsLayout.setOnItemClickListener(new CustomFunctionsLayout.ItemClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Item Click - " + position, Toast.LENGTH_SHORT).show();
            }
        });

        functionsLayout.setOnDetailClickListener(new CustomFunctionsLayout.DetailClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Detail Click - " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setFunctionRate(){
        functionsLayout_1.setFunctionRate(4);
        functionsLayout_2.setFunctionRate(3);
        functionsLayout_3.setFunctionRate(2);
        functionsLayout_4.setFunctionRate(1);
    }

    private void setFunctionTitle(String[] titles){
        functionsLayout_1.setFunctionTitle(titles[0]);
        functionsLayout_2.setFunctionTitle(titles[1]);
        functionsLayout_3.setFunctionTitle(titles[2]);
        functionsLayout_4.setFunctionTitle(titles[3]);
    }

}
