package com.example.jason.learnenglisheveryday.activities.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;
import com.example.jason.learnenglisheveryday.customs.CustomFooterTabBar;
import com.example.jason.learnenglisheveryday.fragments.Home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 25/10/2016.
 */
public class HomeActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_root)
    CustomFooterTabBar tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Utils.getInstance().setupToolbar(activity, toolbar, R.string.home_title);
        setupTabLayout();
    }

    private void setupTabLayout(){
        int firstTab = tabLayout.getEnableFirstTab();
        tabLayout.setTabNotification(geTabNotificationCount());
        if (firstTab == CustomFooterTabBar.HOME_TAB_ID){
            //TO DO SET FIRST FRAGMENT
            Utils.getInstance().ReplaceFirstFragment(activity, new HomeFragment(), R.id.content_fragment);
            Log.e("HOME -->", "OK");
        }
        tabLayout.setOnTabClickListener(new CustomFooterTabBar.TapClickListener() {
            @Override
            public void onClick(int position) {
                // TO DO CHANGE FRAGMENT
                Log.e("HOME -->", "" + position);
            }
        });
    }

    private List<Integer> geTabNotificationCount(){
        List<Integer> notificationCounts = new ArrayList<>();
        notificationCounts.add(CustomFooterTabBar.HOME_TAB_ID, 2);
        notificationCounts.add(CustomFooterTabBar.ACCOUNT_TAB_ID, 0);
        notificationCounts.add(CustomFooterTabBar.GROUPS_TAB_ID, 1);
        return notificationCounts;
    }
}
