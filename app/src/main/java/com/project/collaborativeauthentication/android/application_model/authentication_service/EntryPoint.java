package com.project.collaborativeauthentication.android.application_model.authentication_service;

public class EntryPoint
{
    public static final int STATE_OFF     = 0;
    public static final int STATE_PAUSED  = 1;
    public static final int STATE_READY   = 3;


    private  int state = STATE_OFF;


    public boolean isEntryPointOff()
    {
        return this.state == STATE_OFF;
    }

    public boolean isEntryPointReady()
    {
        return  this.state == STATE_READY;
    }

    public  boolean isEntryPointPaused()
    {
        return this.state == STATE_PAUSED;
    }


    public void startInReady()
    {
        if (isEntryPointOff())
        {
            this.state = STATE_READY;
        }
        else
        {
            throw new IllegalStateException("Entry point was already on");
        }
    }

    public void startInPause()
    {
        if (isEntryPointOff())
        {
            this.state = STATE_PAUSED;
        }
        else
        {
            throw new IllegalStateException("Entry point was already on");
        }
    }

    public void restart()
    {
        if (isEntryPointPaused())
        {
            this.state = STATE_READY;
        }
        else
        {
            throw new IllegalStateException("Entry point was not paused");
        }
    }

    public void  pause()
    {
        if(isEntryPointReady())
        {
            this.state = STATE_PAUSED;
        }
        else
        {
            throw new IllegalStateException("Entry point was not on");
        }
    }

    public void stop()
    {
        if(isEntryPointReady() || isEntryPointPaused())
        {
            this.state = STATE_OFF;
        }
        else
        {
            throw new IllegalStateException("Entry point was not off");
        }
    }
}
