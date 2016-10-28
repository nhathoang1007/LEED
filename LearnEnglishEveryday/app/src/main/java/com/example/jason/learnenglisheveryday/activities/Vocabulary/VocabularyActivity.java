package com.example.jason.learnenglisheveryday.activities.Vocabulary;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.Utils.Utils;
import com.example.jason.learnenglisheveryday.activities.BaseActivity;
import com.example.jason.learnenglisheveryday.fragments.Testing.TestVocabularyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 24/10/2016.
 */
public class VocabularyActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);
        ButterKnife.bind(this);
        setupToolbar();
    }

    private void setupToolbar(){
        Utils.getInstance().setupToolbar(this, toolbar, R.string.vocabulary_title, R.drawable.icon_arrow_left);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.getInstance().replaceFirstFragment(activity, new TestVocabularyFragment(), R.id.content_fragment);
            }
        });
    }
}
