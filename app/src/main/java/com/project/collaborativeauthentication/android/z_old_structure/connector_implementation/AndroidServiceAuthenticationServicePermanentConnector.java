package com.project.collaborativeauthentication.android.z_old_structure.connector_implementation;

import com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces.AuthenticationServicePermanentConnector;
import com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces.BluetoothInformationConnector;
import com.project.collaborativeauthentication.android.z_old_structure.modules_implementations.CustomSingletonModuleAuthenticationService;
import com.project.collaborativeauthentication.android.presenter.authentication_service.AuthenticationEntryPointPresenter;

public class AndroidServiceAuthenticationServicePermanentConnector implements AuthenticationServicePermanentConnector
{

    private final BluetoothInformationConnector bluetoothInformationConnector;
    private final CustomSingletonModuleAuthenticationService authenticationService ;
    private final AuthenticationEntryPointPresenter presenter;

    public AndroidServiceAuthenticationServicePermanentConnector(AuthenticationEntryPointPresenter presenter)
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
