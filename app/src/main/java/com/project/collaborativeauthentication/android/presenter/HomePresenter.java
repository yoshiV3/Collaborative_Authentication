package com.project.collaborativeauthentication.android.presenter;

public interface HomePresenter
{
    void onPrepareOptionsMenu();
    void onStartAuthenticationService();
    void onStopAuthenticationService();
    void onStartDistributedKeyGeneration();
    void onEnableBluetooth();
    void onUnsupportedAction();
    void authenticationServiceStarted(boolean success);
    void authenticationServiceStopped(boolean success);
    void bluetoothResult(int resultCode);
    void bluetoothEnabled(boolean success);
}
