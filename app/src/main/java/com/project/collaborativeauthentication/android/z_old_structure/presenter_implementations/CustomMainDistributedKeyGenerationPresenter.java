package com.project.collaborativeauthentication.android.z_old_structure.presenter_implementations;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.z_old_structure.presenter_interfaces.MainDistributedKeyGenerationPresenter;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.Navigator;

public class CustomMainDistributedKeyGenerationPresenter implements MainDistributedKeyGenerationPresenter {

    private final Navigator navigator;
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
