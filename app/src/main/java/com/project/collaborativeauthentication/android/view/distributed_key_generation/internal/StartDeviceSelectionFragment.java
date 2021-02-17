package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.CustomStartSelectDevicesPresenter;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.StartSelectDevicesPresenter;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartDeviceSelectionView;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.internal.CustomFragment;


public class StartDeviceSelectionFragment extends CustomFragment implements StartDeviceSelectionView {




    private String  login    = "";
    private String  appName  = "";

    private boolean visibilitySessionInfo = false;

    private final StartSelectDevicesPresenter presenter;
    public StartDeviceSelectionFragment()
    {
        this.presenter =new CustomStartSelectDevicesPresenter(getNavigator(), this);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        presenter.getSessionInformation();
        return inflater.inflate(R.layout.fragment_start_device_selection, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        Button button;
        button = ((Button) view.findViewById(R.id.button));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.start();
            }
        });

        ((Button) view.findViewById(R.id.button_cancel_ss)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.stop();
            }
        });

        TextView textViewA = ((TextView) view.findViewById(R.id.textView_anss));
        textViewA.setText(appName);
        TextView textViewL = ((TextView) view.findViewById(R.id.textView_lnss));
        textViewL.setText(login);
        if (!visibilitySessionInfo)
        {
            button.setVisibility(View.GONE);
            textViewA.setVisibility(View.GONE);
            textViewL.setVisibility(View.GONE);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setLogin(String login)
    {
        this.login = login;
    }

    @Override
    public void setApplicationName(String name)
    {
        this.appName = name;
    }

    @Override
    public void setVisibilitySessionInfo(boolean visibilitySessionInfo)
    {
        this.visibilitySessionInfo = visibilitySessionInfo;
    }
}