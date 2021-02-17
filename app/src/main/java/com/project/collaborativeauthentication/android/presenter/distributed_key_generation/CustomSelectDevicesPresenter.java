package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.SelectDevicesView;


import java.util.ArrayList;

public class CustomSelectDevicesPresenter implements SelectDevicesPresenter
{
    private final SelectDevicesView view;
    private final Navigator navigator;
    private final CollaborativeAuthenticationModel model;


    private Session activeSession;

    public CustomSelectDevicesPresenter(SelectDevicesView view, Navigator navigator)
    {
        this.view               = view;
        this.navigator          = navigator;
        this.model              = CustomSingletonAuthenticationModel.getInstance();
    }

    @Override
    public void selectedItemPairedDevices(Possibility item)
    {
        view.pushItemSelectedDevices(item);
    }

    @Override
    public void selectedItemSelectedDevices(Possibility item)
    {
        view.pushItemPairedDevices(item);
    }

    @Override
    public void getItemsPairedDevices()
    {
        SessionModel sessionModel = model.getSessionModel();
        ArrayList<Possibility> possibilities = sessionModel.getInitialPossibilities();
        activeSession = sessionModel.getNextSessionSelectDevices();
        view.pushItemListPairedDevices(possibilities);
    }

    @Override
    public void submit()
    {
        ArrayList<Possibility> choices = view.getSelectedItems();
        if (choices.size() > 0)
        {
            this.activeSession.setChoices(choices);
            model.getSessionModel().pushSessionToWaitForSelectWeights(activeSession);
            activeSession = null;
            navigator.navigate(R.id.submit);
        }
        else
        {
            view.show("Not enough devices were selected.");
        }
    }
}
