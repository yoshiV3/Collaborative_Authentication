package com.project.collaborativeauthentication.android.view.distributed_key_generation;

import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.StartTaskPresenter;

public interface StartTaskView
{
    void setLogin(String login);
    void setApplicationName(String name);
    void setVisibilitySessionInfo(boolean visibilitySessionInfo);
    void setPresenter(StartTaskPresenter presenter);
}
