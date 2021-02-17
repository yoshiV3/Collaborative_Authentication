package com.project.collaborativeauthentication.android.z_old_structure.modules_interfaces;

import com.project.collaborativeauthentication.android.application_model.android_framework.Device;

import java.util.ArrayList;

public interface ModuleNetwork
{
    boolean isNetworkAvailable();
    boolean isNetworkEnabled();



    ArrayList<Device>  getPairedDevices();


}
