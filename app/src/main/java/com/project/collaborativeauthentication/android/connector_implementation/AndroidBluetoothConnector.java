package com.project.collaborativeauthentication.android.connector_implementation;



import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothInformationConnector;
import com.project.collaborativeauthentication.android.presenter.HomePresenter;

import java.util.ArrayList;


public class AndroidBluetoothConnector implements BluetoothConnector
{

    private final HomePresenter                   context;
    private final BluetoothInformationConnector   bluetoothInformationConnector;


    public AndroidBluetoothConnector(HomePresenter context)
    {
        this.context                       = context;
        this.bluetoothInformationConnector = new AndroidBluetoothInformationConnector();
    }



    @Override
    public void enableBluetooth()
    {
        boolean success = !isBluetoothEnabled() && isBluetoothAvailable();
        this.context.bluetoothEnabled(success);

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
