package com.project.collaborativeauthentication.android.connector_implementation;

import com.project.collaborativeauthentication.android.MainActivity;
import com.project.collaborativeauthentication.android.connector_interfaces.MainConnector;

import java.util.ArrayList;

public class AndroidMainConnector implements MainConnector {

    private final MainActivity context;
    private final AndroidBluetoothConnector bluetoothConnector;
    private final AndroidAuthenticationServiceConnector authenticationServiceConnector;


    public AndroidMainConnector(MainActivity context)
    {
        this.context                        = context;
        this.bluetoothConnector             = new AndroidBluetoothConnector(context);
        this.authenticationServiceConnector = new AndroidAuthenticationServiceConnector(context);
    }
    @Override
    public boolean isBluetoothAvailable() {
        return this.bluetoothConnector.isBluetoothAvailable();
    }

    @Override
    public boolean isBluetoothEnabled() {
        return this.bluetoothConnector.isBluetoothEnabled();
    }

    @Override
    public void enableBluetooth()
    {
        this.bluetoothConnector.enableBluetooth();
    }

    @Override
    public ArrayList<String> getPairedBluetoothDevicesNames() {
        return this.bluetoothConnector.getPairedBluetoothDevicesNames();
    }

    @Override
    public void startAuthenticationService()
    {
        if(this.bluetoothConnector.isBluetoothEnabled())
        {
            this.authenticationServiceConnector.startAuthenticationService();
        }
    }

    @Override
    public void stopAuthenticationService()
    {
        this.authenticationServiceConnector.stopAuthenticationService();
    }

    @Override
    public boolean isAuthenticationServiceRunning() {
        return this.authenticationServiceConnector.isAuthenticationServiceRunning();
    }
}
