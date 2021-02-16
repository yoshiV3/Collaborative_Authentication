package com.project.collaborativeauthentication.android.presenter_implementations;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.connector_implementation.CustomSingletonSessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.presenter_interfaces.MainDistributedKeyGenerationPresenter;
import com.project.collaborativeauthentication.android.presenter_interfaces.Navigator;

public class CustomMainDistributedKeyGenerationPresenter implements MainDistributedKeyGenerationPresenter {

    private final Navigator                         navigator;
    private final SessionInformationModuleConnector connector;


    public CustomMainDistributedKeyGenerationPresenter(Navigator navigator)
    {
        this.connector = CustomSingletonSessionInformationModuleConnector.getInstance();
        this.navigator = navigator;
    }
    @Override
    public void cancel()
    {

        {
            connector.stopSession();
            navigator.navigate(R.id.cancel);
        }
    }
}
