package com.project.collaborativeauthentication.android.presenter.main;

import android.app.Activity;

import com.project.collaborativeauthentication.android.application_model.authentication_service.AuthenticationServiceStatusModel;
import com.project.collaborativeauthentication.android.application_model.data.remote.NetworkStatusModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;
import com.project.collaborativeauthentication.android.view.main.HomeView;

public class CustomHomePresenter implements HomePresenter
{
    private final HomeView         view;
    private final ViewStarter      viewStarterDistributedKeyGeneration;
    private final ViewController   starterService;
    private final ViewStarter      viewStarterBluetooth;


    private final CollaborativeAuthenticationModel applicationModel = CustomSingletonAuthenticationModel.getInstance();

    public CustomHomePresenter(HomeView view, ViewStarter viewStarterDistributedKeyGeneration, ViewStarter viewStarterBluetooth, ViewController viewStarterService)
    {

        this.view = view;
        this.viewStarterDistributedKeyGeneration = viewStarterDistributedKeyGeneration;
        this.viewStarterBluetooth                = viewStarterBluetooth;
        this.starterService                      = viewStarterService;
    }


    @Override
    public void onPrepareOptionsMenu()
    {
        NetworkStatusModel adaptStatusModel = applicationModel.getNetworkStatusModel();
        boolean visibilityBluetooth =  adaptStatusModel.isNetworkAvailable() && ! adaptStatusModel.isNetworkEnabled();
        view.setVisibilityBluetoothOption(visibilityBluetooth);

        AuthenticationServiceStatusModel authenticationService = applicationModel.getAuthenticationServiceStatusModel();
        boolean visibilityStop = authenticationService.isAuthenticationServiceActive();
        view.setVisibilityStopAuthenticationServiceOption(visibilityStop);

        boolean visibilityStart = !authenticationService.isAuthenticationServiceActive()&& adaptStatusModel.isNetworkAvailable();
        view.setVisibilityStartAuthenticationServiceOption(visibilityStart);
    }

    @Override
    public void onStartAuthenticationService()
    {
        Boolean canStart = this.applicationModel.getAuthenticationEntryPointStatusModel().canLaunchEntryPoint();
        if (canStart)
        {
            this.starterService.startNewView();
        }
    }

    @Override
    public void onStopAuthenticationService()
    {
       boolean canStop = this.applicationModel.getAuthenticationEntryPointStatusModel().canStopEntryPoint();
       if (canStop)
       {
           starterService.stopView();
       }
    }

    @Override
    public void onStartDistributedKeyGeneration()
    {
        this.viewStarterDistributedKeyGeneration.startNewView();
    }

    @Override
    public void onEnableBluetooth()
    {
        boolean canEnable = this.applicationModel.getNetworkStatusModel().canEnableNetwork();
        if (canEnable)
        {
            viewStarterBluetooth.startNewView();
        }
    }

    @Override
    public void onUnsupportedAction()
    {
        view.showTextOnToast("This action is not (yet) supported.");
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


}
