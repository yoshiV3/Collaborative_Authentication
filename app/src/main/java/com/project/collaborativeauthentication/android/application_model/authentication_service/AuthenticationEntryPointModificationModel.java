package com.project.collaborativeauthentication.android.application_model.authentication_service;

public interface AuthenticationEntryPointModificationModel
{
    boolean notifyStartEntryPoint();
    boolean notifyStopEntryPoint();
    int     notifyBluetoothChanged();
}
