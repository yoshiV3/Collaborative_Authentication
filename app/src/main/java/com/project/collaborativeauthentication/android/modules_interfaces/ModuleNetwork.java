package com.project.collaborativeauthentication.android.modules_interfaces;

import com.project.collaborativeauthentication.android.system.Device;

import java.util.ArrayList;

public interface ModuleNetwork
{
    boolean isNetworkAvailable();
    boolean isNetworkEnabled();



    ArrayList<Device>  getPairedDevices();


}
