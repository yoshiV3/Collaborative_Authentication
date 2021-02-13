package com.project.collaborativeauthentication.android.presenter_implementations;

import com.project.collaborativeauthentication.android.presenter_interfaces.AuthenticationServicePresenter;
import com.project.collaborativeauthentication.android.view_interfaces.AuthenticationServiceView;

public class CustomAuthenticationServicePresenter implements AuthenticationServicePresenter
{

    private final AuthenticationServiceView view;

    public  CustomAuthenticationServicePresenter(AuthenticationServiceView view)
    {
        this.view = view;
    }

    @Override
    public void onStartCommand()
    {
        view.startInForeground();
    }

    @Override
    public void onStopCommand()
    {
        view.stop();
    }

    @Override
    public void onUnsupportedAction()
    {

    }
}
