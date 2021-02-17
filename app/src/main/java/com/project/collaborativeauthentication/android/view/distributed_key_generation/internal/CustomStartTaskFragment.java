package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.StartTaskPresenter;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartTaskView;

public abstract class CustomStartTaskFragment extends CustomFragment implements StartTaskView
{

    private String  login    = "";
    private String  appName  = "";

    private boolean visibilitySessionInfo = false;

    private   StartTaskPresenter presenter;


    public CustomStartTaskFragment()
    {
        super();

    }

    @Override
    public void setPresenter(StartTaskPresenter presenter) {
        this.presenter = presenter;
    }

    protected void getSessionInformation()
    {
        presenter.getSessionInformation();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button;
        button = ((Button) view.findViewById(presenter.getButtonGoId()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.start();
            }
        });

        Button buttonCancel = ((Button) view.findViewById(presenter.getButtonStopId()));

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.stop();
            }
        });

        TextView textViewA = ((TextView) view.findViewById(presenter.getTextViewAppName()));
        textViewA.setText(appName);
        TextView textViewL = ((TextView) view.findViewById(presenter.getTextViewLogin()));
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

    protected String getLogin() {
        return login;
    }

    @Override
    public void setApplicationName(String name)
    {
        this.appName = name;
    }

    protected String getAppName() {
        return appName;
    }

    @Override
    public void setVisibilitySessionInfo(boolean visibilitySessionInfo)
    {
        this.visibilitySessionInfo = visibilitySessionInfo;
    }


    protected   boolean getVisibilitySessionInfo()
    {
        return this.visibilitySessionInfo;
    }


}
