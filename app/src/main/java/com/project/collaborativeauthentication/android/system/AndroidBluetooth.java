package com.project.collaborativeauthentication.android.system;

import android.bluetooth.BluetoothAdapter;

public class AndroidBluetooth   implements Bluetooth
{

    private final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    @Override
    public boolean isBluetoothAvailable() {
        return bluetoothAdapter != null;
    }

    @Override
    public boolean isBluetoothEnabled() {
        if (! isBluetoothAvailable())
        {
            return false;
        }
        return  bluetoothAdapter.isEnabled();
    }
}
