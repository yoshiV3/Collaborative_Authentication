package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

public interface StartScreenPresenter
{


    void clear();

    void selectDevices();

    void selectWeights();

    void mainTask();

    void newSession();

    void getDisplayInformation();

    int getNumberOfSessionsForD();

    int getNumberOfSessionsForW();

    int getNumberOfSessionsForM();
}
