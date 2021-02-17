package com.project.collaborativeauthentication.android.application_model.android_framework;

import java.util.ArrayList;

public interface Bluetooth
{
    boolean isBluetoothAvailable();
    boolean isBluetoothEnabled();

    ArrayList<Device> getPairedDevices();
}
