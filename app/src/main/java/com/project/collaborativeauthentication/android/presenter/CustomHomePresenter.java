package com.project.collaborativeauthentication.android.presenter;

import android.app.Activity;

import com.project.collaborativeauthentication.android.connector_implementation.AndroidMainConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.MainConnector;

public class CustomHomePresenter implements HomePresenter
{
    private final HomeView       view;
    private final ViewStarter    viewStarterDistributedKeyGeneration;
    private final ViewController starterService;
    private final ViewStarter    viewStarterBluetooth;
    private final MainConnector  mainConnector;

    public CustomHomePresenter(HomeView view, ViewStarter viewStarterDistributedKeyGeneration, ViewStarter viewStarterBluetooth, ViewController viewStarterService)
    {

        this.view = view;
        this.viewStarterDistributedKeyGeneration = viewStarterDistributedKeyGeneration;
        this.viewStarterBluetooth                = viewStarterBluetooth;
        this.starterService                      = viewStarterService;
        this.mainConnector = new AndroidMainConnector(this);
    }


    @Override
    public void onPrepareOptionsMenu()
    {
        boolean visibilityBluetooth = this.mainConnector.isBluetoothAvailable() && (!this.mainConnector.isBluetoothEnabled());
        view.setVisibilityBluetoothOption(visibilityBluetooth);

        boolean visibilityStop = this.mainConnector.isAuthenticationServiceRunning();
        view.setVisibilityStopAuthenticationServiceOption(visibilityStop);

        boolean visibilityStart = !this.mainConnector.isAuthenticationServiceRunning() && this.mainConnector.isBluetoothAvailable();
        view.setVisibilityStartAuthenticationServiceOption(visibilityStart);
    }

    @Override
    public void onStartAuthenticationService()
    {
        this.mainConnector.startAuthenticationService();
    }

    @Override
    public void onStopAuthenticationService()
    {
        this.mainConnector.stopAuthenticationService();
    }

    @Override
    public void onStartDistributedKeyGeneration()
    {
        this.viewStarterDistributedKeyGeneration.startNewView();
    }

    @Override
    public void onEnableBluetooth()
    {
        this.mainConnector.enableBluetooth();
    }

    @Override
    public void onUnsupportedAction()
    {
        view.showTextOnToast("This action is not (yet) supported.");
    }

    @Override
    public void authenticationServiceStarted(boolean success)
    {
        if(success)
        {
            this.starterService.startNewView();
        }
        else
        {
            view.showTextOnToast("Cannot start the authentication service.");
        }
    }

    @Override
    public void authenticationServiceStopped(boolean success)
    {
        if(success)
        {
            this.starterService.stopView();
        }
        else
        {
            view.showTextOnToast("Cannot stop the authentication service.");
        }
    }

    @Override
    public void bluetoothResult(int resultCode)
    {
        if (resultCode == Activity.RESULT_OK)
        {
            view.showTextOnToast("Bluetooth was successfully enabled.");
        }
        else
        {
            view.showTextOnToast("Bluetooth was not enabled.");
        }
    }

    @Override
    public void bluetoothEnabled(boolean success)
    {
        if(success)
        {
            this.viewStarterBluetooth.startNewView();
        }
        else
        {
            view.showTextOnToast("Cannot enable bluetooth.");
        }
    }
}
