package com.project.collaborativeauthentication.android.view_interfaces;

public interface AuthenticationServiceView
{
    void  startInForeground();
    void  stop();

    void notifyStartBluetooth();
    void notifyPausedBluetooth();
}
