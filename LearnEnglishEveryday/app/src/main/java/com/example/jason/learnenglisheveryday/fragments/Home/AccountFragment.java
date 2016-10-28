package com.example.jason.learnenglisheveryday.fragments.Home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.jason.learnenglisheveryday.MesageDialogs.JsAlertDialog;
import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;
import com.example.jason.learnenglisheveryday.activities.Start.StartMainActivity;
import com.example.jason.learnenglisheveryday.fragments.BaseFragment;
import com.example.jason.learnenglisheveryday.localStogares.JSPreferenceManager;
import com.example.jason.learnenglisheveryday.localStogares.LoginPreference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jason on 25/10/2016.
 */
public class AccountFragment extends BaseFragment {

    @BindView(R.id.account_login_register)
    LinearLayout layoutLoginOrRegister;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragmnet_account, container, false);
        ButterKnife.bind(this, view);
        setToolbarTitle("Account");
        setupAccountLayout();
        return view;
    }

    private void setupAccountLayout(){
        if (JSPreferenceManager.getInstance().getLoginPreference(context).isLogin()){
            layoutLoginOrRegister.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.button_logout)
    public void showLogoutDialog(){
        JsAlertDialog mAlertDialog = new JsAlertDialog(activity);
        mAlertDialog.setTitle(activity.getString(R.string.logout_alert_title));
        mAlertDialog.setMessage(activity.getString(R.string.logout_alert_message));
        mAlertDialog.setHasCancel(false);
        mAlertDialog.setPositive(activity.getString(R.string.ok));
        mAlertDialog.setPositiveListener(new JsAlertDialog.OnSetPositiveListener() {
            @Override
            public void setPositive() {
                JSPreferenceManager.getInstance().getLoginPreference(activity.getApplicationContext()).setLogin(LoginPreference.STATUS_LOGOUT);
                Intent mIntent = new Intent(activity, StartMainActivity.class);
                mIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mIntent);
                setBackAnimation();
            }
        });
        mAlertDialog.setNegative(activity.getString(R.string.cancel));
        mAlertDialog.setNegativeListener(new JsAlertDialog.OnSetNegativeListener() {
            @Override
            public void setNegative(DialogInterface dialogInterface) {
                dialogInterface.cancel();
            }
        });
        mAlertDialog.Builder();
    }

    @OnClick(R.id.button_login_register)
    public void gotoLogin(){
        Intent mIntent = new Intent(activity, StartMainActivity.class);
        startActivity(mIntent);
        setBackAnimation();
    }
}
