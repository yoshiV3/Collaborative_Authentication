package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartDeviceSelectionView;

import java.util.LinkedList;
import com.project.collaborativeauthentication.R;

public class CustomStartSelectDevicesPresenter implements  StartSelectDevicesPresenter
{

    private  static LinkedList<Session> queue = new LinkedList<>();
    private   final Navigator                        navigator;
    private   final CollaborativeAuthenticationModel model;
    private   final StartDeviceSelectionView         view;

    public CustomStartSelectDevicesPresenter(Navigator navigator, StartDeviceSelectionView  view)
    {
        this.navigator = navigator;
        this.model     = CustomSingletonAuthenticationModel.getInstance();
        this.view      = view;
    }

    @Override
    public void start()
    {
        Session  currentSession   = queue.removeFirst();
        SessionModel sessionModel = model.getSessionModel();
        sessionModel.pushSessionToSelectDevices(currentSession);
        navigator.navigate(R.id.start_sel);
    }

    @Override
    public void stop()
    {
        Session  currentSession   = queue.removeFirst();
        navigator.navigate(R.id.cancel_select_devices);
    }

    @Override
    public void getSessionInformation()
    {
        Session  currentSession;
        if (queue.size() > 0)
        {
            currentSession = queue.getFirst();
        }
        else
        {
            SessionModel sessionModel = model.getSessionModel();
            currentSession = sessionModel.getNextSessionWaitingForSelectDevices();
            if (currentSession != null)
            {
                queue.add(currentSession);
            }
        }
        if (currentSession != null)
        {
            view.setApplicationName(currentSession.getApplicationName());
            view.setLogin(currentSession.getLogin());
            view.setVisibilitySessionInfo(true);
        }
        else
        {
            view.setVisibilitySessionInfo(false);
        }
    }
}
