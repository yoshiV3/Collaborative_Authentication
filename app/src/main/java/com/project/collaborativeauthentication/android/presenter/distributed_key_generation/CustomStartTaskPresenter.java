package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartTaskView;

import java.util.LinkedList;

public abstract class CustomStartTaskPresenter implements StartTaskPresenter
{

    private    final Navigator                         navigator;
    private    final CollaborativeAuthenticationModel  model;
    private    final StartTaskView                     view;


    public CustomStartTaskPresenter(Navigator navigator, StartTaskView view)
    {
        this.model     = CustomSingletonAuthenticationModel.getInstance();
        this.navigator = navigator;
        this.view      = view;
    }





    protected void start(int next)
    {
        Session  currentSession   = popFirstQueue();
        SessionModel sessionModel = model.getSessionModel();
        pushNext(currentSession);
        navigator.navigate(next);
    }

    protected void stop(int next)
    {
        popFirstQueue();
        navigator.navigate(next);
    }

    protected CollaborativeAuthenticationModel getModel()
    {
        return model;
    }



    @Override
    public void getSessionInformation()
    {
        Session  currentSession;
        if (getSizeOfQueue()>0)
        {
            currentSession = getFirstQueue();
        }
        else
        {

            currentSession = getNext();
            if (currentSession != null)
            {
                pushQueue(currentSession);
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


    private   Session getFirstQueue()
    {
        return getQueue().getFirst();
    }
    private  Session popFirstQueue()
    {
        return getQueue().removeFirst();
    }
    public  int  getSizeOfQueue()
    {
        return getQueue().size();
    }
    private  void  pushQueue(Session session)
    {
        getQueue().add(session);
    }

    protected abstract LinkedList<Session> getQueue();
    protected abstract Session  getNext();
    protected abstract void      pushNext(Session session);

}
