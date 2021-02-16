package com.project.collaborativeauthentication.android.connector_implementation;


import com.project.collaborativeauthentication.android.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.modules_implementations.CustomSingletonModuleInformation;
import com.project.collaborativeauthentication.android.modules_implementations.authentication_service.Possibility;
import com.project.collaborativeauthentication.android.modules_interfaces.ModuleInformation;
import com.project.collaborativeauthentication.android.session.Session;
import com.project.collaborativeauthentication.android.system.Device;

import java.util.ArrayList;

public class CustomSingletonSessionInformationModuleConnector implements SessionInformationModuleConnector
{
    private static CustomSingletonSessionInformationModuleConnector instance = null;

    private static int nextSessionNumber       = 0;



    private Session                activeSession;
    private ModuleInformation      moduleInformation;

    private CustomSingletonSessionInformationModuleConnector()
    {

        activeSession          =  null;
        moduleInformation      = CustomSingletonModuleInformation.getInstance();
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
    public void storeSelectedDevices(ArrayList<Possibility> choices)
    { if (this.activeSession  != null)
        {
            activeSession.setChoices(choices);
        }
    }

    @Override
    public ArrayList<Possibility> getPairedDevices()
    {
       ArrayList<Device>         devices         =  moduleInformation.getPairedDevices();
       ArrayList<Possibility>    possibilities   = new ArrayList<>();
       for (Device device: devices)
       {
           possibilities.add(new Possibility(device));
       }
       return possibilities;
    }


    @Override
    public ArrayList<Possibility> getSelected()
    {
        if (this.activeSession  != null)
        {
            return this.activeSession.getChoices();
        }
        return null;
    }


}
