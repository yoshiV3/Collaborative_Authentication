package com.project.collaborativeauthentication.android.connector_implementation;

import com.project.collaborativeauthentication.android.connector_interfaces.AuthenticationServicePermanentConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothInformationConnector;
import com.project.collaborativeauthentication.android.modules_implementations.CustomSingletonModuleAuthenticationService;

public class AndroidServiceAuthenticationServicePermanentConnector implements AuthenticationServicePermanentConnector
{

    private final BluetoothInformationConnector              bluetoothInformationConnector;
    private final CustomSingletonModuleAuthenticationService authenticationService ;

    public AndroidServiceAuthenticationServicePermanentConnector()
    {
        this.bluetoothInformationConnector = new AndroidBluetoothInformationConnector();
        this.authenticationService         = CustomSingletonModuleAuthenticationService.getInstance();
    }

    @Override
    public void start()
    {
        if (bluetoothInformationConnector.isBluetoothEnabled())
        {
            authenticationService.start();
        }
        else
        {
            authenticationService.pause();
        }
    }

    @Override
    public void stop()
    {
        authenticationService.stop();
    }
}
