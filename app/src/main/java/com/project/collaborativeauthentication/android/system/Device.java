package com.project.collaborativeauthentication.android.system;

public class Device
{
    private final String   name;
    private final String   address;
    private final Location location;


    public Device(String name, String address, Location location)
    {
        this.name     = name;
        this.address  = address;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getAddress() {
        return address;
    }
}
