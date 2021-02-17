package com.project.collaborativeauthentication.android.view.authentication_service;

public interface AuthenticationEntryPointForegroundServiceView
{
    void  startInForeground();
    void  stop();

    void  coldStop();
    void  notifyError();

    void notifyErrorWithoutStop();

    void notifyStartBluetooth();
    void notifyPausedBluetooth();
}
