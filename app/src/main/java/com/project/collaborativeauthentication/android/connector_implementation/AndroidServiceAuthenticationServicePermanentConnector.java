package com.project.collaborativeauthentication.android.connector_implementation;

import com.project.collaborativeauthentication.android.connector_interfaces.AuthenticationServicePermanentConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothInformationConnector;
import com.project.collaborativeauthentication.android.modules_implementations.CustomSingletonModuleAuthenticationService;
import com.project.collaborativeauthentication.android.presenter_interfaces.AuthenticationServicePresenter;

public class AndroidServiceAuthenticationServicePermanentConnector implements AuthenticationServicePermanentConnector
{

    private final BluetoothInformationConnector              bluetoothInformationConnector;
    private final CustomSingletonModuleAuthenticationService authenticationService ;
    private final AuthenticationServicePresenter             presenter;

    public AndroidServiceAuthenticationServicePermanentConnector(AuthenticationServicePresenter presenter)
    {
        this.bluetoothInformationConnector = new AndroidBluetoothInformationConnector();
        this.authenticationService         = CustomSingletonModuleAuthenticationService.getInstance();
        this.presenter                     = presenter;
    }

    @Override
    public void start()
    {
        if (bluetoothInformationConnector.isBluetoothEnabled())
        {
            authenticationService.start();
            presenter.notifyBluetoothStart();
        }
        else
        {
            authenticationService.pause();
            presenter.notifyBluetoothPaused();
        }
    }

    @Override
    public void stop()
    {
        authenticationService.stop();
    }
}
