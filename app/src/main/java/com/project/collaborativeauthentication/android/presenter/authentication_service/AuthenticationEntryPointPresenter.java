package com.project.collaborativeauthentication.android.presenter.authentication_service;

public interface AuthenticationEntryPointPresenter
{
    void onStartCommand();
    void onStopCommand();
    void onUnsupportedAction();

    void notifyStateBluetoothChanged();

}
