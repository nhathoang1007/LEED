package com.example.jason.learnenglisheveryday.customs;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jason.learnenglisheveryday.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 24/10/2016.
 */
public class CustomTestLayout extends LinearLayout {

    @BindView(R.id.checkbox_question_A)
    CheckBox checkBoxAnswerA;

    @BindView(R.id.textView_question_A)
    TextView tvAnswerA;

    @BindView(R.id.layout_question_A)
    LinearLayout layoutAnswerA;

    @BindView(R.id.checkbox_question_B)
    CheckBox checkBoxAnswerB;

    @BindView(R.id.textView_question_B)
    TextView tvAnswerB;

    @BindView(R.id.layout_question_B)
    LinearLayout layoutAnswerB;

    @BindView(R.id.checkbox_question_C)
    CheckBox checkBoxAnswerC;

    @BindView(R.id.textView_question_C)
    TextView tvAnswerC;

    @BindView(R.id.layout_question_C)
    LinearLayout layoutAnswerC;

    @BindView(R.id.checkbox_question_D)
    CheckBox checkBoxAnswerD;

    @BindView(R.id.textView_question_D)
    TextView tvAnswerD;

    @BindView(R.id.layout_question_D)
    LinearLayout layoutAnswerD;

    private OnQuestionClickListener listener;
    public static final int ANSWER_NONE = -1;
    public static final int ANSWER_A = 0;
    public static final int ANSWER_B = 1;
    public static final int ANSWER_C = 2;
    public static final int ANSWER_D = 3;
    public static final int MAX_ANSWER_COUNT = 4;
    private int currentAnswer = ANSWER_NONE;

    public CustomTestLayout(Context context) {
        super(context);
    }

    public void setQuestionOnClickListener(OnQuestionClickListener listener){
        this.listener = listener;
    }

    public CustomTestLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_question_item, this, true);
        ButterKnife.bind(this, view);
        setChangeAnswer(layoutAnswerA, ANSWER_A, checkBoxAnswerA, checkBoxAnswerB, checkBoxAnswerC, checkBoxAnswerD);
        setChangeAnswer(layoutAnswerB, ANSWER_B, checkBoxAnswerB, checkBoxAnswerA, checkBoxAnswerC, checkBoxAnswerD);
        setChangeAnswer(layoutAnswerC, ANSWER_C, checkBoxAnswerC, checkBoxAnswerA, checkBoxAnswerB, checkBoxAnswerD);
        setChangeAnswer(layoutAnswerD, ANSWER_D, checkBoxAnswerD, checkBoxAnswerB, checkBoxAnswerC, checkBoxAnswerA);
    }

    private void setChangeAnswer(LinearLayout layout_answer, final int answer, final CheckBox cb_1, final CheckBox cb_2, final CheckBox cb_3, final CheckBox cb_4){
        layout_answer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentAnswer != answer) {
                    cb_1.setChecked(true);
                    cb_2.setChecked(false);
                    cb_3.setChecked(false);
                    cb_4.setChecked(false);
                    listener.QuestionListener(answer);
                    currentAnswer = answer;
                }
            }
        });
    }

    public void unCheckAllAnswer(){
        checkBoxAnswerA.setChecked(false);
        checkBoxAnswerB.setChecked(false);
        checkBoxAnswerC.setChecked(false);
        checkBoxAnswerD.setChecked(false);
    }

    public void setListQuestion(List<String> questions){
        List<Integer> randomNumbers = getRandomAnswers();
        Log.e("QuestionRandom", "" + randomNumbers.get(ANSWER_A) + "-" + randomNumbers.get(ANSWER_B) + "-" + randomNumbers.get(ANSWER_C) + "-" + randomNumbers.get(ANSWER_D));
        tvAnswerA.setText(questions.get(randomNumbers.get(ANSWER_A)));
        tvAnswerB.setText(questions.get(randomNumbers.get(ANSWER_B)));
        tvAnswerC.setText(questions.get(randomNumbers.get(ANSWER_C)));
        tvAnswerD.setText(questions.get(randomNumbers.get(ANSWER_D)));

    }

    private List<Integer> getRandomAnswers(){
        List<Integer> randomNumbers = new ArrayList<>();
        int temp = ANSWER_NONE;
        int maxCount = MAX_ANSWER_COUNT;
        int count = 0;
        do {
            if (temp == maxCount){
                maxCount = maxCount - 1;
            } else {
                int random = new Random().nextInt(maxCount);
                if (!randomNumbers.contains(random)){
                    randomNumbers.add(random);
                    temp = random;
                    count++;
                }
            }
        } while (count != MAX_ANSWER_COUNT);

        return randomNumbers;
    }

    public interface OnQuestionClickListener{
        void QuestionListener(int answer);
    }
}
