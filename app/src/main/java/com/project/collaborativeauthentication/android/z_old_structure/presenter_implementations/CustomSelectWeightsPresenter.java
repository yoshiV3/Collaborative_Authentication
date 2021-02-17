package com.project.collaborativeauthentication.android.z_old_structure.presenter_implementations;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.Navigator;
import com.project.collaborativeauthentication.android.z_old_structure.presenter_interfaces.SelectWeightsPresenter;
import com.project.collaborativeauthentication.android.z_old_structure.view_interfaces.SelectWeightsView;

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
