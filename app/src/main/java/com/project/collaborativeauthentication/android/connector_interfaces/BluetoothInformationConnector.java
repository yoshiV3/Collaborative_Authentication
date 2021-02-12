package com.project.collaborativeauthentication.android.connector_interfaces;

import java.util.ArrayList;

public interface BluetoothInformationConnector
{
    boolean isBluetoothAvailable();

    boolean isBluetoothEnabled();

    ArrayList<String> getPairedBluetoothDevicesNames();
}
