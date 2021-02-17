package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.LoginDetailsView;
import com.project.collaborativeauthentication.R;
public class CustomLoginPresenter implements  LoginDetailsPresenter
{

    private static  final String APPLICATION_NAME_DEFAULT = "Collaborative Authentication Manager";
    private final Navigator                           navigator;
    private final LoginDetailsView                    view;
    private final CollaborativeAuthenticationModel    model = CustomSingletonAuthenticationModel.getInstance();

    public CustomLoginPresenter(Navigator navigator, LoginDetailsView view)
    {
        this.navigator = navigator;
        this.view      = view;
    }

    @Override
    public void getApplicationName()
    {
        this.view.setApplicationName(APPLICATION_NAME_DEFAULT);
    }

    @Override
    public void submit()
    {
        String login = view.getChosenLogin();
        SessionModel sessionModel = model.getSessionModel();
        sessionModel.createNewSession(APPLICATION_NAME_DEFAULT, login);
        navigator.navigate(R.id.start);
    }
}
