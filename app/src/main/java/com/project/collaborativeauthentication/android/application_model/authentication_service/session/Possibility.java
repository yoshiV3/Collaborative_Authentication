package com.project.collaborativeauthentication.android.application_model.authentication_service.session;

import com.project.collaborativeauthentication.android.application_model.android_framework.Device;

public class Possibility
{


    private final Device device;
    private int          weight = 1;


    public Possibility(Device device)
    {
        this.device      = device;
    }

    public String getName() {
        return device.getName();
    }

    public Device getDevice() {
        return device;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
