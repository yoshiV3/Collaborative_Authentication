package com.project.collaborativeauthentication.android.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;


import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter_implementations.CustomMainDistributedKeyGenerationPresenter;
import com.project.collaborativeauthentication.android.presenter_interfaces.MainDistributedKeyGenerationPresenter;


public class MainDistributedKeyGenerationFragment extends CustomFragment  {


    private final MainDistributedKeyGenerationPresenter presenter;
    public MainDistributedKeyGenerationFragment()
    {
        this.presenter = new CustomMainDistributedKeyGenerationPresenter(getNavigator());
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        view.findViewById(R.id.button_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.cancel();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}