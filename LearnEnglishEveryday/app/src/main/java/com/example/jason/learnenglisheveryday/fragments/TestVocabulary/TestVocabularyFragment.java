package com.example.jason.learnenglisheveryday.fragments.TestVocabulary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.customs.CustomTestLayout;
import com.example.jason.learnenglisheveryday.fragments.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 24/10/2016.
 */
public class TestVocabularyFragment extends BaseFragment {

    @BindView(R.id.customTestLayout)
    CustomTestLayout CustomTestLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.frament_test, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        setupTestLesson();
    }

    private void setupTestLesson(){
        CustomTestLayout.unCheckAllAnswer();
        CustomTestLayout.setListQuestion(getAnswer());
        CustomTestLayout.setQuestionOnClickListener(new CustomTestLayout.OnQuestionClickListener() {
            @Override
            public void QuestionListener(int answer) {
                Toast.makeText(activity.getApplicationContext(), "" + answer, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public List<String> getAnswer(){
        List<String> answer = new ArrayList<>();
        answer.add("answer 1");
        answer.add("answer 2");
        answer.add("answer 3");
        answer.add("answer 4");
        return answer;
    }
}
