package com.example.jason.learnenglisheveryday.customs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.jason.learnenglisheveryday.R;


public class FragmentTransactionExtended implements FragmentManager.OnBackStackChangedListener{
    private boolean mDidSlideOut = false;
    private boolean mIsAnimating = false;
    private FragmentTransaction mFragmentTransaction;
    private Context mContext;
    private Fragment mFirstFragment, mSecondFragment;
    private int mContainerID;
    private int mTransitionType;
    public static final int MOVE_LEFT = 0;
    public static final int MOVE_RIGHT = 1;
    public static final int MOVE_TOP = 2;
    public static final int MOVE_BOTTOM = 3;
    public static final int ZOOM_FROM_LEFT_CORNER = 4;
    public static final int ZOOM_FROM_RIGHT_CORNER = 5;
    public static final int ZOOM_SLIDE_HORIZONTAL = 6;
    public static final int ZOOM_SLIDE_VERTICAL = 7;
    public static final int SLIDING = 11;

    public FragmentTransactionExtended(Context context, FragmentTransaction fragmentTransaction, Fragment firstFragment, Fragment secondFragment, int containerID) {
        this.mFragmentTransaction = fragmentTransaction;
        this.mContext = context;
        this.mFirstFragment = firstFragment;
        this.mSecondFragment = secondFragment;
        this.mContainerID = containerID;
    }

    public void addTransition(int transitionType) {
        this.mTransitionType = transitionType;
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
            case ZOOM_FROM_LEFT_CORNER:
            	transitionZoomFromLeftCorner();
                break;
            case ZOOM_FROM_RIGHT_CORNER:
            	transitionZoomFromRightCorner();
                break;
            case ZOOM_SLIDE_HORIZONTAL:
            	transitionZoomSlideHorizontal();
                break;
            case ZOOM_SLIDE_VERTICAL:
            	transitionZoomSlideVertical();
                break;
        }
        mFragmentTransaction.replace(mContainerID, mSecondFragment);
    }

    private void transitionZoomSlideVertical() {
        mFragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    private void transitionZoomSlideHorizontal() {
        mFragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    private void transitionZoomFromRightCorner() {
        mFragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_bottom, R.anim.slide_out_top);
    }

    private void transitionZoomFromLeftCorner() {
        mFragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top, R.anim.slide_in_bottom, R.anim.slide_out_top);
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

    private void switchFragments() {
        ((AppCompatActivity) this.mContext).getSupportFragmentManager().addOnBackStackChangedListener(this);

        if (mIsAnimating) {
            return;
        }
        mIsAnimating = true;
        if (mDidSlideOut) {
            mDidSlideOut = false;
            ((AppCompatActivity) mContext).getSupportFragmentManager().popBackStack();
        } else {
            mDidSlideOut = true;
            Animator.AnimatorListener listener = new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator arg0) {
                    mFragmentTransaction.setCustomAnimations(R.anim.slide_in_left, 0, 0, R.anim.slide_out_right);
                    mFragmentTransaction.add(mContainerID, mSecondFragment);
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();
                }
            };
            slideBack(listener);
        }
    }

    public void slideBack(Animator.AnimatorListener listener) {
        View movingFragmentView = mFirstFragment.getView();
        movingFragmentView.setPivotY(movingFragmentView.getHeight()/2);
        movingFragmentView.setPivotX(movingFragmentView.getWidth() / 2);

        PropertyValuesHolder rotateX = PropertyValuesHolder.ofFloat("rotationX", 40f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.8f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.8f);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 0.5f);
        ObjectAnimator movingFragmentAnimator = ObjectAnimator.ofPropertyValuesHolder(movingFragmentView, rotateX, scaleX, scaleY, alpha);

        ObjectAnimator movingFragmentRotator = ObjectAnimator.ofFloat(movingFragmentView, "rotationX", 0);
        movingFragmentRotator.setStartDelay(mContext.getResources().getInteger(R.integer.half_slide_up_down_duration));

        AnimatorSet s = new AnimatorSet();
        s.playTogether(movingFragmentAnimator, movingFragmentRotator);
        s.addListener(listener);
        s.start();
    }

    public void slideForward() {
        View movingFragmentView = mFirstFragment.getView();
        PropertyValuesHolder rotateX = PropertyValuesHolder.ofFloat("rotationX", 40f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 1.0f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 1.0f);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha", 1f);
        ObjectAnimator movingFragmentAnimator = ObjectAnimator.ofPropertyValuesHolder(movingFragmentView, rotateX, scaleX, scaleY, alpha);

        ObjectAnimator movingFragmentRotator = ObjectAnimator.ofFloat(movingFragmentView, "rotationX", 0);
        movingFragmentRotator.setStartDelay(mContext.getResources().getInteger(R.integer.half_slide_up_down_duration));

        AnimatorSet s = new AnimatorSet();
        s.playTogether(movingFragmentAnimator, movingFragmentRotator);
        s.setStartDelay(mContext.getResources().getInteger(R.integer.slide_up_down_duration));
        s.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                mIsAnimating = false;
                mDidSlideOut = true;
            }
        });
        s.start();
        ((AppCompatActivity) mContext).getSupportFragmentManager().removeOnBackStackChangedListener(this);
    }

    public void commit(){
        switch (mTransitionType){
            case SLIDING:
                switchFragments();
                break;
            default:
                mFragmentTransaction.addToBackStack(null);
                mFragmentTransaction.commit();
                break;
        }
    }

    @Override
    public void onBackStackChanged() {
        switch (mTransitionType){
            case SLIDING:
                if (!mDidSlideOut) {
                        slideForward();
                }else{
                    mDidSlideOut= false;
                }
                break;
        }
    }
}
