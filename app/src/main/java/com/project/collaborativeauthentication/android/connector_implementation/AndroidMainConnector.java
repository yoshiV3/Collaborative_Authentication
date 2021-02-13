package com.project.collaborativeauthentication.android.connector_implementation;

import com.project.collaborativeauthentication.android.connector_interfaces.MainConnector;
import com.project.collaborativeauthentication.android.presenter_interfaces.HomePresenter;

import java.util.ArrayList;

public class AndroidMainConnector implements MainConnector {

    private final HomePresenter context;
    private final AndroidBluetoothConnector bluetoothConnector;
    private final AndroidActivityAuthenticationServiceConnector authenticationServiceConnector;


    public AndroidMainConnector(HomePresenter context)
    {
        this.context                        = context;
        this.bluetoothConnector             = new AndroidBluetoothConnector(context);
        this.authenticationServiceConnector = new AndroidActivityAuthenticationServiceConnector(context);
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
        if(this.bluetoothConnector.isBluetoothAvailable())
        {
            this.authenticationServiceConnector.startAuthenticationService();
        }
        else
        {
            this.context.authenticationServiceStarted(false);
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
