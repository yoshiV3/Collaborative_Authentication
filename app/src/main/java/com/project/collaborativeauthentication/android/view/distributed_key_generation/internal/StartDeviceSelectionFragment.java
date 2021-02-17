package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.CustomStartSelectDevicesPresenter;



public class StartDeviceSelectionFragment extends CustomStartTaskFragment
{
    public StartDeviceSelectionFragment()
    {
        setPresenter(new CustomStartSelectDevicesPresenter(getNavigator(), this));
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
        return inflater.inflate(R.layout.fragment_start_device_selection, container, false);
    }
}