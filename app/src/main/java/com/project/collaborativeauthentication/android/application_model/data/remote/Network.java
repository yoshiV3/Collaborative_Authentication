package com.project.collaborativeauthentication.android.application_model.data.remote;

import com.project.collaborativeauthentication.android.application_model.android_framework.AndroidBluetooth;
import com.project.collaborativeauthentication.android.application_model.android_framework.Bluetooth;
import com.project.collaborativeauthentication.android.application_model.android_framework.Device;

import java.util.ArrayList;

public class Network
{
    private Bluetooth bluetooth =  new AndroidBluetooth();

    public boolean isNetworkAvailable()
    {
        return bluetooth.isBluetoothAvailable();
    }

    public boolean isNetworkEnabled()
    {
        return bluetooth.isBluetoothEnabled();
    }

    public ArrayList<Device> getPairedDevices()
    {
        return bluetooth.getPairedDevices();
    }
}
