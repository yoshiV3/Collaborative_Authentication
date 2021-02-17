package com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces;

import java.util.ArrayList;

public interface BluetoothInformationConnector
{
    boolean isBluetoothAvailable();

    boolean isBluetoothEnabled();

    ArrayList<String> getPairedBluetoothDevicesNames();
}
