package com.project.collaborativeauthentication.android.application_model.authentication_service;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.SessionLifeCycleManager;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.SessionsStatus;

public class AuthenticationService
{

    private SessionLifeCycleManager sessionLifeCycleManager;

    public  AuthenticationService()
    {
        clear();
    }


    public void clear()
    {
        this.sessionLifeCycleManager = new SessionLifeCycleManager();
    }




    public void createSession(String applicationName, String login)
    {
        sessionLifeCycleManager.createSession(applicationName, login);
    }

    public int getNumberOfWaitingSessionSelectDevices()
    {
        SessionsStatus status = sessionLifeCycleManager.getSessionsStatus();
        return status.getNumberWaitingForSelectDevices();
    }
    public int getNumberOfWaitingSessionSelectWeights()
    {
        SessionsStatus status = sessionLifeCycleManager.getSessionsStatus();
        return  status.getNumberWaitingForSelectWeights();
    }
    public int getNumberOfWaitingSessionSelectMain()
    {
        SessionsStatus status = sessionLifeCycleManager.getSessionsStatus();
        return  status.getNumberOfWaitingForMain();
    }

    public void pushNextSessionSelectDevices(Session session)
    {
        sessionLifeCycleManager.pushNextSessionSelectDevices(session);
    }

    public void pushNextSessionSelectWeights(Session session)
    {
        sessionLifeCycleManager.pushNextSessionSelectWeights(session);
    }


    public void pushNextSessionMain(Session session)
    {
        sessionLifeCycleManager.pushNextSessionMain(session);
    }
    public void pushNextSessionWaitingForSelectWeights(Session session)
    {
        sessionLifeCycleManager.pushNextSessionWaitingForSelectWeights(session);
    }

    public void pushNextWaitForMain(Session session)
    {
        sessionLifeCycleManager.pushNextWaitForMain(session);
    }



    public  Session getNextSessionSelectDevices()
    {
        return sessionLifeCycleManager.getNextSessionSelectDevices();
    }
    public Session getNextSessionWaitingForSelectDevices()
    {
        return sessionLifeCycleManager.getNextSessionWaitingForSelectDevices();
    }
    public Session getNextSessionSelectWeights()
    {
        return  sessionLifeCycleManager.getNextSessionSelectWeights();
    }
    public Session getNextSessionWaitingForSelectWeights()
    {
        return sessionLifeCycleManager.getNextSessionWaitingForSelectWeights();
    }
    public Session getNextSessionMain()
    {
        return sessionLifeCycleManager.getNextSessionMain();
    }
    public Session getNextSessionWaitingForMain()
    {
        return  sessionLifeCycleManager.getNextSessionWaitingForMain();
    }

}
