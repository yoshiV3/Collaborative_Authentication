package com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces;

public interface AuthenticationServiceConnector
{

    void     startAuthenticationService();

    void     stopAuthenticationService();

    boolean  isAuthenticationServiceRunning();
}
