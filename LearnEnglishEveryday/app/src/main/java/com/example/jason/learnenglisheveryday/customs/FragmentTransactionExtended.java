package com.example.jason.learnenglisheveryday.customs;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.example.jason.learnenglisheveryday.R;


public class FragmentTransactionExtended {
    private FragmentTransaction mFragmentTransaction;
    private Fragment mSecondFragment;
    private boolean fragmentPopped;
    private int mContainerID;
    public static final int MOVE_LEFT = 0;
    public static final int MOVE_RIGHT = 1;
    public static final int MOVE_TOP = 2;
    public static final int MOVE_BOTTOM = 3;

    public FragmentTransactionExtended(FragmentTransaction fragmentTransaction, Fragment secondFragment, boolean fragmentPopped, int containerID) {
        this.mFragmentTransaction = fragmentTransaction;
        this.mSecondFragment = secondFragment;
        this.fragmentPopped = fragmentPopped;
        this.mContainerID = containerID;
    }

    public void addTransition(int transitionType) {
        switch (transitionType) {
            case MOVE_LEFT:
                transitionMoveLeft();
                break;
            case MOVE_RIGHT:
                transitionMoveRight();
                break;
            case MOVE_TOP:
                transitionMoveTop();
                break;
            case MOVE_BOTTOM:
                transitionMoveBottom();
                break;
        }
        mFragmentTransaction.replace(mContainerID, mSecondFragment);
    }

    private void transitionMoveBottom() {
        mFragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    private void transitionMoveTop() {
        mFragmentTransaction.setCustomAnimations(R.anim.slide_in_top, R.anim.slide_out_bottom, R.anim.slide_in_top, R.anim.slide_out_bottom);
    }

    private void transitionMoveRight() {
        mFragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void transitionMoveLeft() {
        mFragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void commit(){
//        if (!fragmentPopped) {
//            mFragmentTransaction.addToBackStack(mSecondFragment.getClass().getName());
//        }
        mFragmentTransaction.commit();
    }
}
