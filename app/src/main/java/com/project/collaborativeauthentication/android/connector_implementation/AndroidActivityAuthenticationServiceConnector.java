package com.project.collaborativeauthentication.android.connector_implementation;


import com.project.collaborativeauthentication.android.connector_interfaces.AuthenticationServiceConnector;
import com.project.collaborativeauthentication.android.modules_implementations.CustomSingletonModuleAuthenticationService;
import com.project.collaborativeauthentication.android.modules_interfaces.ModuleAuthenticationService;
import com.project.collaborativeauthentication.android.presenter_interfaces.HomePresenter;

public class AndroidActivityAuthenticationServiceConnector implements AuthenticationServiceConnector
{

    private final HomePresenter context;
    private boolean            running = false;
    private ModuleAuthenticationService moduleAuthenticationService;
    public AndroidActivityAuthenticationServiceConnector(HomePresenter context)
    {
        this.context                       = context;
        this.moduleAuthenticationService   = CustomSingletonModuleAuthenticationService.getInstance();
    }

    @Override
    public void startAuthenticationService() {
        if (this.moduleAuthenticationService.isAuthenticationServiceOn())
        {
            this.context.authenticationServiceStarted(false);
        }
        else
        {
            this.context.authenticationServiceStarted(true);
        }
    }

    @Override
    public void stopAuthenticationService()
    {
        if (this.moduleAuthenticationService.isAuthenticationServiceOn())
        {
            this.context.authenticationServiceStopped(true);
        }
        else
        {
            this.context.authenticationServiceStarted(false);
        }
    }

    @Override
    public boolean isAuthenticationServiceRunning()
    {
        return this.moduleAuthenticationService.isAuthenticationServiceOn();
    }

}
