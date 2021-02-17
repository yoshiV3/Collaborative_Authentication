package com.project.collaborativeauthentication.android.view.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;

import java.util.ArrayList;

public interface SelectDevicesView
{
    void pushItemSelectedDevices(Possibility option);
    void pushItemPairedDevices(Possibility option);

    void pushItemListPairedDevices(ArrayList<Possibility> possibilities);

    ArrayList<Possibility> getSelectedItems();

    void show(String text);
}
