package com.project.collaborativeauthentication.android.connector_implementation;


import com.project.collaborativeauthentication.android.connector_interfaces.AuthenticationServiceConnector;
import com.project.collaborativeauthentication.android.presenter.HomePresenter;

public class AndroidAuthenticationServiceConnector implements AuthenticationServiceConnector
{

    private final HomePresenter context;
    private boolean            running = false;
    public AndroidAuthenticationServiceConnector(HomePresenter context)
    {
        this.context = context;
    }

    @Override
    public void startAuthenticationService() {
        if (this.running)
        {
            this.context.authenticationServiceStarted(false);
        }
        else
        {
            this.running = true;
            this.context.authenticationServiceStarted(true);
        }
    }

    @Override
    public void stopAuthenticationService()
    {
        if (this.running)
        {
            this.running = false;
            this.context.authenticationServiceStopped(true);
        }
        else
        {
            this.context.authenticationServiceStarted(false);
        }
    }

    @Override
    public boolean isAuthenticationServiceRunning() {
        return this.running;
    }

}
