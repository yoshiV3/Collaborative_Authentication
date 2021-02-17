package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.CustomStartMainPresenter;



public class StartMainFragment extends CustomStartTaskFragment {





    public StartMainFragment()
    {
        setPresenter(new CustomStartMainPresenter(getNavigator(), this));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        getSessionInformation();
        return inflater.inflate(R.layout.fragment_start_main, container, false);
    }

}