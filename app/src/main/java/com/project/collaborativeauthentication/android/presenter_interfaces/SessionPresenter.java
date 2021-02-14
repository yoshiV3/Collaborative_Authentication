package com.project.collaborativeauthentication.android.presenter_interfaces;

import com.project.collaborativeauthentication.android.session.Selection;

import java.util.ArrayList;

public interface SessionPresenter
{
    int createNewSession();
    void storeSelectedDevices(ArrayList<String>  names, int sessionNumber);
    void storeSelectedWeights( ArrayList<Selection> selections, int sessionNumber);

    ArrayList<String> getSelectedDeviceNames(int sessionNumber);
    ArrayList<Selection> getSelections(int sessionNumber);
}
