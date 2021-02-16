package com.project.collaborativeauthentication.android.connector_interfaces;

import com.project.collaborativeauthentication.android.modules_implementations.authentication_service.Possibility;


import java.util.ArrayList;

public interface SessionInformationModuleConnector
{
    int createNewSession();
    void storeSelectedDevices(ArrayList<Possibility>  names);



    ArrayList<Possibility> getPairedDevices();
    ArrayList<Possibility> getSelected();
}
