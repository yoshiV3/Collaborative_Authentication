package com.project.collaborativeauthentication.android.presenter;

public interface NavigationPresenter
{
    interface Locator
    {
        int getCurrentPosition();
    }

    void onBackPressed();
}
