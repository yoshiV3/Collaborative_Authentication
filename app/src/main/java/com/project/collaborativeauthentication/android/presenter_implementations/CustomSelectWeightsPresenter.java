package com.project.collaborativeauthentication.android.presenter_implementations;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.connector_implementation.CustomSingletonSessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.modules_implementations.authentication_service.Possibility;
import com.project.collaborativeauthentication.android.presenter_interfaces.Navigator;
import com.project.collaborativeauthentication.android.presenter_interfaces.SelectWeightsPresenter;
import com.project.collaborativeauthentication.android.view_interfaces.SelectWeightsView;

import java.util.ArrayList;

public class CustomSelectWeightsPresenter implements SelectWeightsPresenter
{

    private final SelectWeightsView view;
    private final Navigator navigator;
    private final SessionInformationModuleConnector sessionConnector;

    public CustomSelectWeightsPresenter(SelectWeightsView view, Navigator navigator)
    {
        this.view = view;
        this.navigator          = navigator;
        this.sessionConnector   = CustomSingletonSessionInformationModuleConnector.getInstance();
    }

    @Override
    public void submit()
    {
        navigator.navigate(R.id.submit_weights);
    }

    @Override
    public ArrayList<Possibility> getSelectedDeviceNames() {
        return sessionConnector.getSelected();
    }
}
