package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

public interface ControllerPresenter
{
    interface Locator
    {
        int getCurrentPosition();
    }

    void onBackPressed();
}
