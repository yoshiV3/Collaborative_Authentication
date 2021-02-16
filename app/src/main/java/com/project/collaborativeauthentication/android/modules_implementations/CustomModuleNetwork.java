package com.project.collaborativeauthentication.android.modules_implementations;

import com.project.collaborativeauthentication.android.modules_interfaces.ModuleNetwork;
import com.project.collaborativeauthentication.android.system.Bluetooth;
import com.project.collaborativeauthentication.android.system.Device;

import java.util.ArrayList;

public class CustomModuleNetwork implements ModuleNetwork
{
    private final Bluetooth bluetoothSystem;
    public CustomModuleNetwork(Bluetooth bluetoothSystem)
    {
        this.bluetoothSystem = bluetoothSystem;
    }
    @Override
    public boolean isNetworkAvailable() {
        return bluetoothSystem.isBluetoothAvailable();
    }

    @Override
    public boolean isNetworkEnabled() {
        return bluetoothSystem.isBluetoothEnabled();
    }

    @Override
    public ArrayList<Device> getPairedDevices() {
        return bluetoothSystem.getPairedDevices();
    }
}
