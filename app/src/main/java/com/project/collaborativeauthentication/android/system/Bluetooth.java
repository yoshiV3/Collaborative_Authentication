package com.project.collaborativeauthentication.android.system;

import java.util.ArrayList;

public interface Bluetooth
{
    boolean isBluetoothAvailable();
    boolean isBluetoothEnabled();

    ArrayList<Device> getPairedDevices();
}
