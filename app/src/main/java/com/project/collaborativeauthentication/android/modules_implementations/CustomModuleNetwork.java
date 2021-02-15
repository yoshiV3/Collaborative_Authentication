package com.project.collaborativeauthentication.android.modules_implementations;

import com.project.collaborativeauthentication.android.modules_interfaces.ModuleNetwork;
import com.project.collaborativeauthentication.android.system.Bluetooth;

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
}
