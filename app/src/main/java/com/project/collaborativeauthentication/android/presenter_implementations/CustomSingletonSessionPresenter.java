package com.project.collaborativeauthentication.android.presenter_implementations;


import com.project.collaborativeauthentication.android.presenter_interfaces.SessionPresenter;
import com.project.collaborativeauthentication.android.session.Selection;
import com.project.collaborativeauthentication.android.session.Session;

import java.util.ArrayList;

public class CustomSingletonSessionPresenter implements SessionPresenter
{
    private static CustomSingletonSessionPresenter instance = null;

    private static int nextSessionNumber       = 0;



    private Session activeSession;

    private CustomSingletonSessionPresenter()
    {
        activeSession =  null;
    }

    public static CustomSingletonSessionPresenter getInstance()
    {
        if(instance == null)
        {
            instance = new CustomSingletonSessionPresenter();
        }
        return instance;
    }

    @Override
    public int createNewSession()
    {
        Session newSession = new Session();
        int sessionNumber  = newSession.getSessionNumber();
        return sessionNumber;
    }

    @Override
    public void storeSelectedDevices(ArrayList<String> names, int sessionNumber)
    { if (this.activeSession  != null && this.activeSession.getSessionNumber() == sessionNumber)
        {
            activeSession.setNames(names);
        }
    }

    @Override
    public void storeSelectedWeights(ArrayList<Selection> selections, int sessionNumber)
    { if (this.activeSession  != null && this.activeSession.getSessionNumber() == sessionNumber)
        {
            this.activeSession.setSelections(selections);
        }
    }

    @Override
    public ArrayList<String> getSelectedDeviceNames(int sessionNumber)
    {
        if (this.activeSession  != null && this.activeSession.getSessionNumber() == sessionNumber)
        {
            return this.activeSession.getNames();
        }
        return null;
    }

    @Override
    public ArrayList<Selection> getSelections(int sessionNumber)
    {
        if (this.activeSession  != null && this.activeSession.getSessionNumber() == sessionNumber)
        {
            return this.activeSession.getSelections();
        }
        return null;
    }

}
