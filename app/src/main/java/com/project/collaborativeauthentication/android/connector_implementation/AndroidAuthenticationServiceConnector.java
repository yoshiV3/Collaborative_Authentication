package com.project.collaborativeauthentication.android.connector_implementation;


import com.project.collaborativeauthentication.android.MainActivity;
import com.project.collaborativeauthentication.android.connector_interfaces.AuthenticationServiceConnector;

public class AndroidAuthenticationServiceConnector implements AuthenticationServiceConnector
{

    private final MainActivity context;
    private boolean            running = false;
    public AndroidAuthenticationServiceConnector(MainActivity context)
    {
        this.context = context;
    }

    @Override
    public void startAuthenticationService() {
        this.running = true;
        this.context.showTextWithToast("Launched authentication service ");
    }

    @Override
    public void stopAuthenticationService()
    {
        this.running = false;
        this.context.showTextWithToast("Stopped authentication service ");
    }

    @Override
    public boolean isAuthenticationServiceRunning() {
        return this.running;
    }

}
