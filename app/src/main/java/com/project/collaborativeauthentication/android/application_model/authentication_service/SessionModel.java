package com.project.collaborativeauthentication.android.application_model.authentication_service;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;

import java.util.ArrayList;

public interface SessionModel
{
    void createNewSession(String applicationName, String login);
    void pushSessionToSelectDevices(Session session);
    void pushSessionToWaitForSelectWeights(Session session);
    void pushSessionToSelectWeights(Session session);
    void pushSessionToWaitForMain(Session session);
    void pushSessionToMain(Session session);


    void clear();

    ArrayList<Possibility> getInitialPossibilities();


    int getNumberOfWaitingSessionSelectDevices();
    int getNumberOfWaitingSessionSelectWeights();
    int getNumberOfWaitingSessionSelectMain();

    Session getNextSessionSelectDevices();
    Session getNextSessionWaitingForSelectDevices();
    Session getNextSessionSelectWeights();
    Session getNextSessionWaitingForSelectWeights();
    Session getNextSessionMain();
    Session getNextSessionWaitingForMain();

}
