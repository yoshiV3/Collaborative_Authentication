package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.CustomStartSelectWeightsPresenter;


public class StartWeightSelectionFragment extends CustomStartTaskFragment
{

    public StartWeightSelectionFragment()
    {
        super();
        setPresenter(new CustomStartSelectWeightsPresenter(getNavigator(), this));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getSessionInformation();
        return inflater.inflate(R.layout.fragment_start_weight_selection, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
    }


}