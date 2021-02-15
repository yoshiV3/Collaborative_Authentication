package com.project.collaborativeauthentication.android.modules_implementations;

import com.project.collaborativeauthentication.android.modules_interfaces.ModuleInformation;
import com.project.collaborativeauthentication.android.modules_interfaces.ModuleNetwork;
import com.project.collaborativeauthentication.android.system.AndroidBluetooth;
import com.project.collaborativeauthentication.android.system.Bluetooth;

public class CustomSingletonModuleInformation implements ModuleInformation
{
    private static CustomSingletonModuleInformation instance             = null;
    private static Bluetooth                        bluetoothSystem      = new AndroidBluetooth();


    private final ModuleNetwork  moduleNetwork = new CustomModuleNetwork(bluetoothSystem);

    private CustomSingletonModuleInformation(){}

    public static CustomSingletonModuleInformation getInstance()
    {
        if(instance == null)
        {
            instance = new CustomSingletonModuleInformation();
        }
        return instance;
    }

    @Override
    public boolean isNetworkAvailable() {
        return false;
    }

    @Override
    public boolean isNetworkEnabled() {
        return false;
    }
}
