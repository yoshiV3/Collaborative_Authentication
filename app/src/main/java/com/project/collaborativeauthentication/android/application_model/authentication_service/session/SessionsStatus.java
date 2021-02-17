package com.project.collaborativeauthentication.android.application_model.authentication_service.session;

public interface SessionsStatus
{
    int getNumberWaitingForSelectDevices();
    int getNumberWaitingForSelectWeights();
    int getNumberOfWaitingForMain();
}
