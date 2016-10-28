package com.example.jason.learnenglisheveryday.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.jason.learnenglisheveryday.R;

/**
 * Created by jason on 27/10/2016.
 */
public class PostedAdapter extends RecyclerView.Adapter<PostedAdapter.PostedViewHolder>{

    private Context context;

    public PostedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public PostedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.groups_posted_item, null);
        return new PostedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class PostedViewHolder extends RecyclerView.ViewHolder{

        public PostedViewHolder(View itemView) {
            super(itemView);
        }
    }
}
