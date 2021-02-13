package com.project.collaborativeauthentication.android.presenter;

public interface AuthenticationServicePresenter
{
    void onStartCommand();
    void onStopCommand();
    void onUnsupportedAction();
}
