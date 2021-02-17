package com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;


import java.util.ArrayList;

public interface SessionInformationModuleConnector
{
    int createNewSession();
    void stopSession();
    void storeSelectedDevices(ArrayList<Possibility>  names);




    ArrayList<Possibility> getPairedDevices();
    ArrayList<Possibility> getSelected();
}
