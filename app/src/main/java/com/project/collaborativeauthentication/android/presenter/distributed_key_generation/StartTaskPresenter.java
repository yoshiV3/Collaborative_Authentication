package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartTaskView;

import java.util.Queue;

public interface StartTaskPresenter
{


    void start();
    void stop();
    void getSessionInformation();


    int getButtonGoId();
    int getButtonStopId();
    int getTextViewLogin();
    int getTextViewAppName();
}
