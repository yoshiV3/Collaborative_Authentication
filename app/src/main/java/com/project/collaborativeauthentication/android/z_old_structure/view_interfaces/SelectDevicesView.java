package com.project.collaborativeauthentication.android.z_old_structure.view_interfaces;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;

import java.util.ArrayList;

public interface SelectDevicesView
{
    void pushItemPairedDevices(Possibility item);
    void pushItemSelectedDevices(Possibility item);
    void pushItemListPairedDevices(ArrayList<Possibility> items);
    ArrayList<Possibility> getSelectedItems();
}
