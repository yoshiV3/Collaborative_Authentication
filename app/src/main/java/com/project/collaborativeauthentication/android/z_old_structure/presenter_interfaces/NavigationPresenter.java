package com.project.collaborativeauthentication.android.z_old_structure.presenter_interfaces;

public interface NavigationPresenter
{
    interface Locator
    {
        int getCurrentPosition();
    }

    void onBackPressed();
}
