package com.project.collaborativeauthentication.android.presenter;

import java.util.ArrayList;

public interface SelectDevicesView
{
    void pushItemPairedDevices(String item);
    void pushItemSelectedDevices(String item);
    void pushItemListPairedDevices(ArrayList<String> items);
    ArrayList<String> getSelectedItems();
}
