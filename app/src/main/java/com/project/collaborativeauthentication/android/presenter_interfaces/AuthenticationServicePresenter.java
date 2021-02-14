package com.project.collaborativeauthentication.android.presenter_interfaces;

public interface AuthenticationServicePresenter
{
    void onStartCommand();
    void onStopCommand();
    void onUnsupportedAction();

    void notifyStateBluetoothChanged();
    void notifyBluetoothPaused();
    void notifyBluetoothStart();
}
