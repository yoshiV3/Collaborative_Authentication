package com.project.collaborativeauthentication.android.view_interfaces;

import com.project.collaborativeauthentication.android.modules_implementations.authentication_service.Possibility;

import java.util.ArrayList;

public interface SelectDevicesView
{
    void pushItemPairedDevices(Possibility item);
    void pushItemSelectedDevices(Possibility item);
    void pushItemListPairedDevices(ArrayList<Possibility> items);
    ArrayList<Possibility> getSelectedItems();
}
