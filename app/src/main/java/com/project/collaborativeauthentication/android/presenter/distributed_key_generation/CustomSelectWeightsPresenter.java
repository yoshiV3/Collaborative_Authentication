package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.SelectWeightsView;


import java.util.ArrayList;

public class CustomSelectWeightsPresenter implements SelectWeightsPresenter
{

    private final SelectWeightsView view;
    private final Navigator                        navigator;
    private final CollaborativeAuthenticationModel model;


    private Session activeSession;

    public CustomSelectWeightsPresenter(SelectWeightsView view, Navigator navigator)
    {
        this.view         = view;
        this.navigator    = navigator;
        this.model        = CustomSingletonAuthenticationModel.getInstance();

    }

    @Override
    public void submit()
    {
        model.getSessionModel().pushSessionToWaitForMain(activeSession);
        activeSession = null;
        navigator.navigate(R.id.submit_weights);
    }

    @Override
    public ArrayList<Possibility> getSelectedDeviceNames() {
        activeSession = model.getSessionModel().getNextSessionSelectWeights();
        return activeSession.getChoices();
    }
}
