package com.project.collaborativeauthentication.android.connector_interfaces;

public interface AuthenticationServiceConnector
{

    void     startAuthenticationService();

    void     stopAuthenticationService();

    boolean  isAuthenticationServiceRunning();
}
