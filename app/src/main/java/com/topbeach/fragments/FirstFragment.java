package com.topbeach.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.topbeach.R;

import butterknife.BindView;

/**
 * Created by Alchimy on 6/29/2017.
 */

public class FirstFragment extends Fragment {
    @BindView(R.id.fragment_images_id)
    RecyclerView fragment_images_id;

    private PresenterFragment presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PresenterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.initFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
