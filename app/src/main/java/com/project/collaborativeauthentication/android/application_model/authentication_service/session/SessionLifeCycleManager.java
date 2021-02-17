package com.project.collaborativeauthentication.android.application_model.authentication_service.session;

import java.util.LinkedList;

public class SessionLifeCycleManager
{
    private LinkedList<Session> waitForSelectDevicesQueue = new LinkedList<>();
    private LinkedList<Session> waitForSelectWeightQueue  = new LinkedList<>();
    private LinkedList<Session> waitForMainQueue          = new LinkedList<>();

    private Session nextSelectDevices = null;
    private Session nextSelectWeights= null;
    private Session nextMain = null;



    public void createSession(String applicationName, String login)
    {
        Session newSession = new Session(applicationName, login);
        waitForSelectDevicesQueue.add(newSession);
    }


    public SessionsStatus getSessionsStatus()
    {
        return new SessionsStatus() {
            @Override
            public int getNumberWaitingForSelectDevices() {
                return waitForSelectDevicesQueue.size();
            }

            @Override
            public int getNumberWaitingForSelectWeights()
            {
                return  waitForSelectWeightQueue.size();
            }

            @Override
            public int getNumberOfWaitingForMain() {
                return waitForMainQueue.size();
            }
        };
    }

    public void pushNextSessionSelectDevices(Session session)
    {
        if (nextSelectDevices == null)
        {
            throw new IllegalStateException();
        }
        nextSelectDevices = session;
    }

    public void pushNextSessionSelectWeights(Session session)
    {
        if (nextSelectWeights == null)
        {
            throw new IllegalStateException();
        }
        nextSelectWeights = session;
    }


    public void pushNextSessionMain(Session session)
    {
        if (nextMain == null)
        {
            throw new IllegalStateException();
        }
        nextMain = session;
    }
    public void pushNextSessionWaitingForSelectWeights(Session session)
    {
        waitForSelectWeightQueue.add(session);
    }

    public void pushNextWaitForMain(Session session)
    {
        waitForMainQueue.add(session);
    }





    public Session getNextSessionSelectDevices()
    {
        Session  nextSession = nextSelectDevices;
        nextSelectDevices    = null;
        return  nextSession;
    }
    public Session getNextSessionWaitingForSelectDevices()
    {
        if (waitForSelectDevicesQueue.size() == 0)
        {
            return null;
        }
        Session nextSession = waitForSelectDevicesQueue.removeFirst();
        return nextSession;
    }
    public Session getNextSessionSelectWeights()
    {
        Session  nextSession = nextSelectWeights;
        nextSelectWeights   = null;
        return  nextSession;
    }
    public Session getNextSessionWaitingForSelectWeights()
    {
        if (waitForSelectWeightQueue.size() == 0)
        {
            return null;
        }
        Session nextSession = waitForSelectWeightQueue.removeFirst();
        return nextSession;
    }
    public Session getNextSessionMain()
    {
        Session  nextSession = nextMain;
        nextMain  = null;
        return  nextSession;
    }
    public Session getNextSessionWaitingForMain()
    {
        if (waitForMainQueue.size() == 0)
        {
            return null;
        }
        Session nextSession = waitForMainQueue.removeFirst();
        return nextSession;
    }
}
