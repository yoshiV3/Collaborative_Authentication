package com.project.collaborativeauthentication.android.z_old_structure.connector_implementation;

import android.bluetooth.BluetoothAdapter;

import com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces.BluetoothInformationConnector;

import java.util.ArrayList;
import java.util.Arrays;

public class AndroidBluetoothInformationConnector implements BluetoothInformationConnector
{
    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();


    @Override
    public boolean isBluetoothAvailable() {
        return (this.bluetoothAdapter != null);
    }

    @Override
    public boolean isBluetoothEnabled() {
        return this.bluetoothAdapter.isEnabled();
    }

    @Override
    public ArrayList<String> getPairedBluetoothDevicesNames() {
        return new ArrayList<String>(Arrays.asList("dev1", "dev2"));
    }

}
