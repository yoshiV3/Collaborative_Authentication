package com.project.collaborativeauthentication.android.connector_implementation;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;

import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothInformationConnector;

import java.util.ArrayList;
import java.util.Arrays;

public class AndroidBluetoothConnector implements BluetoothConnector
{

    private final Activity                       context;
    private final BluetoothInformationConnector  bluetoothInformationConnector;


    public AndroidBluetoothConnector(Activity context)
    {
        this.context = context;
        this.bluetoothInformationConnector = new AndroidBluetoothInformationConnector();
    }



    @Override
    public void enableBluetooth()
    {
        //TO DO
    }


    @Override
    public boolean isBluetoothAvailable() {
        return this.bluetoothInformationConnector.isBluetoothAvailable();
    }

    @Override
    public boolean isBluetoothEnabled() {
        return this.bluetoothInformationConnector.isBluetoothEnabled();
    }

    @Override
    public ArrayList<String> getPairedBluetoothDevicesNames() {
        return this.bluetoothInformationConnector.getPairedBluetoothDevicesNames();
    }
}
