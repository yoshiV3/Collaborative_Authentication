package com.project.collaborativeauthentication.android.modules_interfaces;

public interface ModuleAuthenticationService
{
    boolean isAuthenticationServiceOn();
    void    pause();
    void    start();
    void    stop();
}
