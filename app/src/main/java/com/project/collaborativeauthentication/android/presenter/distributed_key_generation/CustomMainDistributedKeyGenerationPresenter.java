package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;


public class CustomMainDistributedKeyGenerationPresenter implements MainDistributedKeyGenerationPresenter {

    private final Navigator                        navigator;
    private final CollaborativeAuthenticationModel model;
    private Session activeSession;


    public CustomMainDistributedKeyGenerationPresenter(Navigator navigator)
    {
        this.model     = CustomSingletonAuthenticationModel.getInstance();
        this.navigator = navigator;
        activeSession  = model.getSessionModel().getNextSessionMain();
    }
    @Override
    public void cancel()
    {
        navigator.navigate(R.id.cancel);
    }
}
