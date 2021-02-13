package com.project.collaborativeauthentication.android.presenter_interfaces;

public interface NavigationPresenter
{
    interface Locator
    {
        int getCurrentPosition();
    }

    void onBackPressed();
}
