package com.project.collaborativeauthentication.android.z_old_structure.modules_implementations;

import com.project.collaborativeauthentication.android.z_old_structure.modules_interfaces.ModuleAuthenticationService;

public class CustomSingletonModuleAuthenticationService implements ModuleAuthenticationService
{
    public static final int STATE_OFF     = 0;
    public static final int STATE_PAUSED  = 1;
    public static final int STATE_READY   = 2;

    private static CustomSingletonModuleAuthenticationService instance = null;

    private int state = STATE_OFF;

    private CustomSingletonModuleAuthenticationService(){}

    public static CustomSingletonModuleAuthenticationService getInstance()
    {
        if(instance == null)
        {
            instance = new CustomSingletonModuleAuthenticationService();
        }
        return instance;
    }


    @Override
    public boolean isAuthenticationServiceOn() {
        return this.state == STATE_PAUSED || this.state == STATE_READY;
    }

    @Override
    public void pause()
    {
        this.state = STATE_PAUSED;
    }

    @Override
    public void start()
    {
        this.state = STATE_READY;
    }

    @Override
    public void stop()
    {
        this.state = STATE_OFF;
    }
}
