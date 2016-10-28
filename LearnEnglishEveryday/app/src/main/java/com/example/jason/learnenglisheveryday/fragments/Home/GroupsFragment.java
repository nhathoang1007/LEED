package com.example.jason.learnenglisheveryday.fragments.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jason.learnenglisheveryday.R;
import com.example.jason.learnenglisheveryday.adapters.PostedAdapter;
import com.example.jason.learnenglisheveryday.fragments.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 26/10/2016.
 */
public class GroupsFragment extends BaseFragment {

    @BindView(R.id.recyclerView_posted)
    RecyclerView rcvPosted;

    private PostedAdapter mPostedAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_groups, container, false);
        ButterKnife.bind(this, view);
        setToolbarTitle("Groups");
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        showPosted();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.group_fragment_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add_group:
                Toast.makeText(context, "Add group", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_search_group:
                Toast.makeText(context, "search group", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showPosted(){
        rcvPosted.setLayoutManager(new GridLayoutManager(activity, 1));
        mPostedAdapter = new PostedAdapter(context);
        rcvPosted.setAdapter(mPostedAdapter);
    }
}
