package com.project.collaborativeauthentication.android.connector_implementation;


import com.project.collaborativeauthentication.android.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.session.Selection;
import com.project.collaborativeauthentication.android.session.Session;

import java.util.ArrayList;

public class CustomSingletonSessionInformationModuleConnector implements SessionInformationModuleConnector
{
    private static CustomSingletonSessionInformationModuleConnector instance = null;

    private static int nextSessionNumber       = 0;



    private Session activeSession;

    private CustomSingletonSessionInformationModuleConnector()
    {
        activeSession =  null;
    }

    public static CustomSingletonSessionInformationModuleConnector getInstance()
    {
        if(instance == null)
        {
            instance = new CustomSingletonSessionInformationModuleConnector();
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
    public void storeSelectedDevices(ArrayList<String> names)
    { if (this.activeSession  != null)
        {
            activeSession.setNames(names);
        }
    }

    @Override
    public void storeSelectedWeights(ArrayList<Selection> selections)
    { if (this.activeSession  != null)
        {
            this.activeSession.setSelections(selections);
        }
    }

    @Override
    public ArrayList<String> getSelectedDeviceNames()
    {
        if (this.activeSession  != null)
        {
            return this.activeSession.getNames();
        }
        return null;
    }

    @Override
    public ArrayList<Selection> getSelections()
    {
        if (this.activeSession  != null)
        {
            return this.activeSession.getSelections();
        }
        return null;
    }

}
