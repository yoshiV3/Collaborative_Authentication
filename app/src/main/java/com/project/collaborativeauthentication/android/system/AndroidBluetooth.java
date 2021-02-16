package com.project.collaborativeauthentication.android.system;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import java.util.ArrayList;
import java.util.Set;


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

    @Override
    public ArrayList<Device> getPairedDevices() {
        Set<BluetoothDevice> androidBluetoothDevices = this.bluetoothAdapter.getBondedDevices();
        ArrayList<Device>    appNetworkDevices       = new ArrayList<>();
        for (BluetoothDevice bluetoothDevice: androidBluetoothDevices)
        {
            appNetworkDevices.add(new Device(bluetoothDevice.getName(), bluetoothDevice.getAddress(), Location.REMOTE));
        }
        appNetworkDevices.add(new Device("this", "localhost", Location.LOCAL));
        return appNetworkDevices;
    }
}
