package com.project.collaborativeauthentication.android.modules_implementations.authentication_service;

import com.project.collaborativeauthentication.android.system.Device;

public class Possibility
{
    private static  int currentNextIdentifier = 0;


    public static void startNewBatch()
    {
        currentNextIdentifier = 0;
    }

    public static int getNextIdentifier()
    {
        int newIdentifier     = currentNextIdentifier;
        currentNextIdentifier = currentNextIdentifier +1;
        return   newIdentifier;
    }

    private final Device device;
    private final int    identifier;
    private int          weight = 1;


    public Possibility(Device device)
    {
        this.device      = device;
        this.identifier  = getNextIdentifier();
    }

    public String getName() {
        return device.getName();
    }

    public Device getDevice() {
        return device;
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
