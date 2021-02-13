package com.project.collaborativeauthentication.android.view_interfaces;

import java.util.ArrayList;

public interface SelectDevicesView
{
    void pushItemPairedDevices(String item);
    void pushItemSelectedDevices(String item);
    void pushItemListPairedDevices(ArrayList<String> items);
    ArrayList<String> getSelectedItems();
}
