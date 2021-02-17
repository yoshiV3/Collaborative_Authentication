package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.collaborativeauthentication.R;

public class StartMainFragment extends CustomFragment
{
    public StartMainFragment()
    {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_screen_distributed_key_generation, container, false);
    }
}
