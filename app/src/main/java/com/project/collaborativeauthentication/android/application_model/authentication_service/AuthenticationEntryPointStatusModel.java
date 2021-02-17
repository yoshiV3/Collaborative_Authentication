package com.project.collaborativeauthentication.android.application_model.authentication_service;

public interface AuthenticationEntryPointStatusModel
{
    boolean isAuthenticationEntryPointActive();

    boolean isAuthenticationEntryPointSleeping();

    boolean isAuthenticationEntryPointStopped();


    boolean canLaunchEntryPoint();
    boolean canStopEntryPoint();
}
