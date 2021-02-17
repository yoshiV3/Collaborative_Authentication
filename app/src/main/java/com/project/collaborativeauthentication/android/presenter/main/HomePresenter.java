package com.project.collaborativeauthentication.android.presenter.main;

public interface HomePresenter
{
    void onPrepareOptionsMenu();
    void onStartAuthenticationService();
    void onStopAuthenticationService();
    void onStartDistributedKeyGeneration();
    void onEnableBluetooth();
    void onUnsupportedAction();
    void bluetoothResult(int resultCode);
}
