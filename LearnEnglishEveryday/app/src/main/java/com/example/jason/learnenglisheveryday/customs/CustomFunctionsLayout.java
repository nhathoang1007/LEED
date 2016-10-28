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
import com.example.jason.learnenglisheveryday.Utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 25/10/2016.
 */
public class CustomFunctionsLayout extends LinearLayout {

    @BindView(R.id.function_item)
    RelativeLayout functionItem;

    @BindView(R.id.function_title)
    TextView tvFunctionTitle;

    @BindView(R.id.function_rate_textView)
    TextView tvFunctionRate;

    @BindView(R.id.function_detail_layout)
    MaterialRippleLayout layoutFunLayoutDetail;

    private ItemClickListener itemClickListener;
    private DetailClickListener detailClickListener;

    public CustomFunctionsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_function_item, this, true);
        ButterKnife.bind(this, view);
        functionItem.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onClick(v);
            }
        });

        layoutFunLayoutDetail.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                detailClickListener.onClick(v);
            }
        });
    }

    public void setFunctionRate(int rate){
        tvFunctionRate.setText(rate + "+");
    }

    public void setOnDetailClickListener(DetailClickListener detailClickListener){
        this.detailClickListener = detailClickListener;

    }

    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public void setFunctionTitle(String title){
        tvFunctionTitle.setText(title);
        Utils.getInstance().setupHyperLink(tvFunctionTitle);
    }

    public interface ItemClickListener{
        void onClick(View view);
    }

    public interface DetailClickListener{
        void onClick(View view);
    }

}
