package com.project.collaborativeauthentication.android.presenter_implementations;

import com.project.collaborativeauthentication.android.connector_implementation.AndroidBluetoothInformationConnector;
import com.project.collaborativeauthentication.android.connector_implementation.AndroidServiceAuthenticationServicePermanentConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.AuthenticationServicePermanentConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothInformationConnector;
import com.project.collaborativeauthentication.android.presenter_interfaces.AuthenticationServicePresenter;
import com.project.collaborativeauthentication.android.view_interfaces.AuthenticationServiceView;

public class CustomAuthenticationServicePresenter implements AuthenticationServicePresenter
{

    private final AuthenticationServiceView     view;

    private final AuthenticationServicePermanentConnector authenticationServicePermanentConnector;

    public  CustomAuthenticationServicePresenter(AuthenticationServiceView view)
    {
        this.view = view;
        this.authenticationServicePermanentConnector = new AndroidServiceAuthenticationServicePermanentConnector();
    }

    @Override
    public void onStartCommand()
    {
        view.startInForeground();
        authenticationServicePermanentConnector.start();
    }

    @Override
    public void onStopCommand()
    {
        view.stop();
        authenticationServicePermanentConnector.stop();
    }

    @Override
    public void onUnsupportedAction()
    {

    }

    @Override
    public void notifyStateBluetoothChanged()
    {
        authenticationServicePermanentConnector.start();
    }

}
