package com.project.collaborativeauthentication.android.connector_interfaces;

import com.project.collaborativeauthentication.android.session.Selection;

import java.util.ArrayList;

public interface SessionInformationModuleConnector
{
    int createNewSession();
    void storeSelectedDevices(ArrayList<String>  names);
    void storeSelectedWeights( ArrayList<Selection> selections);

    ArrayList<String> getSelectedDeviceNames();
    ArrayList<Selection> getSelections();
}
