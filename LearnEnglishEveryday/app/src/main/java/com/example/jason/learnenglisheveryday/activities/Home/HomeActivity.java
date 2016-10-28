package com.example.jason.learnenglisheveryday.activities.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;
import com.example.jason.learnenglisheveryday.customs.CustomFooterTabBar;
import com.example.jason.learnenglisheveryday.fragments.Home.AccountFragment;
import com.example.jason.learnenglisheveryday.fragments.Home.GroupsFragment;
import com.example.jason.learnenglisheveryday.fragments.Home.HomeFragment;
import com.example.jason.learnenglisheveryday.localStogares.JSPreferenceManager;

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

    private Fragment homeFragment, accountFragment, groupsFragment;
    private int currentFragmentId = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        homeFragment = new HomeFragment();
        accountFragment = new AccountFragment();
        groupsFragment = new GroupsFragment();
        Utils.getInstance().setupToolbar(activity, toolbar, R.string.home_title);
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupTabLayout();
    }

    private void setupTabLayout(){
        int firstTab = tabLayout.getEnableFirstTab();
        tabLayout.setTabNotification(geTabNotificationCount());
        if (firstTab == CustomFooterTabBar.HOME_TAB_ID){
            //TO DO SET FIRST FRAGMENT
            currentFragmentId = CustomFooterTabBar.HOME_TAB_ID;
            Utils.getInstance().replaceSecondFragment(activity, homeFragment, R.id.content_fragment);
            Log.e("HOME -->", "OK");
        }
        tabLayout.setOnTabClickListener(new CustomFooterTabBar.TapClickListener() {
            @Override
            public void onClick(int position) {
                // TO DO CHANGE FRAGMENT
                Log.e("HOME -->", "" + position);
                if (position != currentFragmentId) {
                    int animation = 0;
                    if (position < currentFragmentId) {
                        animation = 0;
                    } else {
                        animation = 1;
                    }
                    switch (position){
                        case CustomFooterTabBar.ACCOUNT_TAB_ID:
                            Utils.getInstance().replaceSecondFragment(activity, accountFragment, animation);
                            currentFragmentId = position;
                            break;
                        case CustomFooterTabBar.HOME_TAB_ID:
                            Utils.getInstance().replaceSecondFragment(activity, homeFragment, animation);
                            currentFragmentId = position;
                            break;
                        case CustomFooterTabBar.GROUPS_TAB_ID:
                            Utils.getInstance().replaceSecondFragment(activity, groupsFragment, animation);
                            currentFragmentId = position;
                            break;
                        default: break;
                    }
                }
            }
        });
    }

    private List<Integer> geTabNotificationCount(){
        List<Integer> notificationCounts = new ArrayList<>();
        notificationCounts.add(CustomFooterTabBar.GROUPS_TAB_ID, 1);
        notificationCounts.add(CustomFooterTabBar.HOME_TAB_ID, 2);
        notificationCounts.add(CustomFooterTabBar.ACCOUNT_TAB_ID, 0);
        return notificationCounts;
    }

    @Override
    public void onBackPressed() {
        if (JSPreferenceManager.getInstance().getLoginPreference(context).isLogin()) {
            Intent mIntent = new Intent(Intent.ACTION_MAIN);
            mIntent.addCategory(Intent.CATEGORY_HOME);
            startActivity(mIntent);
        } else {
            super.onBackPressed();
        }
        setBackAnimation();
    }
}
