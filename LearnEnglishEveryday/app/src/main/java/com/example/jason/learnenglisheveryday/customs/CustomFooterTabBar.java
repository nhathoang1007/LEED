package com.example.jason.learnenglisheveryday.customs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.example.jason.learnenglisheveryday.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 25/10/2016.
 */
public class CustomFooterTabBar extends LinearLayout {

    @BindView(R.id.tab_groups)
    MaterialRippleLayout tabGroups;

    @BindView(R.id.tab_groups_bottom_line)
    View viewGroupsBottomLine;

    @BindView(R.id.tab_groups_notification)
    RelativeLayout tabGroupsNotification;

    @BindView(R.id.tab_groups_notification_count)
    TextView tvGroupsNotificationCount;

    @BindView(R.id.tab_home)
    MaterialRippleLayout tabHome;

    @BindView(R.id.tab_home_bottom_line)
    View viewHomeBottomLine;

    @BindView(R.id.tab_home_notification)
    RelativeLayout tabHomeNotification;

    @BindView(R.id.tab_home_notification_count)
    TextView tvHomeNotificationCount;

    @BindView(R.id.tab_account)
    MaterialRippleLayout tabAccount;

    @BindView(R.id.tab_account_bottom_line)
    View viewAccountBottomLine;

    @BindView(R.id.tab_account_notification)
    RelativeLayout tabAccountNotification;

    @BindView(R.id.tab_account_notification_count)
    TextView tvAccountNotificationCount;

    private TapClickListener listener;
    public static final int ACCOUNT_TAB_ID = 2;
    public static final int HOME_TAB_ID = 1;
    public static final int GROUPS_TAB_ID = 0;

    public void setOnTabClickListener(TapClickListener listener){
        this.listener = listener;
    }

    public CustomFooterTabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_footer_tab_bar, this, true);
        ButterKnife.bind(this, view);
        setTabClick(tabAccount, viewAccountBottomLine, ACCOUNT_TAB_ID, tabGroups, viewGroupsBottomLine, tabHome, viewHomeBottomLine);
        setTabClick(tabGroups, viewGroupsBottomLine, GROUPS_TAB_ID, tabAccount, viewAccountBottomLine, tabHome, viewHomeBottomLine);
        setTabClick(tabHome, viewHomeBottomLine, HOME_TAB_ID, tabAccount, viewAccountBottomLine, tabGroups, viewGroupsBottomLine);
    }

    private void setTabClick(final MaterialRippleLayout tab_1, final View line_1, final int position,
                             final MaterialRippleLayout tab_2, final View line_2,
                             final MaterialRippleLayout tab_3, final View line_3){
        tab_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                tab_1.setAlpha(1.f);
                line_1.setVisibility(VISIBLE);
                tab_2.setAlpha(.2f);
                line_2.setVisibility(INVISIBLE);
                tab_3.setAlpha(.2f);
                line_3.setVisibility(INVISIBLE);
                listener.onClick(position);
            }
        });
    }

    public void setTabNotification(List<Integer> notifications){
        if (notifications.get(HOME_TAB_ID) == 0){
            tabHomeNotification.setVisibility(INVISIBLE);
        } else {
            tvHomeNotificationCount.setText("" + notifications.get(HOME_TAB_ID));
        }

        if (notifications.get(GROUPS_TAB_ID) == 0){
            tabGroupsNotification.setVisibility(INVISIBLE);
        } else {
            tvGroupsNotificationCount.setText("" + notifications.get(GROUPS_TAB_ID));
        }

        if (notifications.get(ACCOUNT_TAB_ID) == 0){
            tabAccountNotification.setVisibility(INVISIBLE);
        } else {
            tvAccountNotificationCount.setText("" + notifications.get(ACCOUNT_TAB_ID));
        }
    }

    public int getEnableFirstTab(){
        tabHome.setAlpha(1.f);
        viewHomeBottomLine.setVisibility(VISIBLE);
        tabAccount.setAlpha(.2f);
        viewAccountBottomLine.setVisibility(INVISIBLE);
        tabGroups.setAlpha(.2f);
        viewGroupsBottomLine.setVisibility(INVISIBLE);
        return HOME_TAB_ID;
    }

    public interface TapClickListener{
        void onClick(int position);
    }
}
