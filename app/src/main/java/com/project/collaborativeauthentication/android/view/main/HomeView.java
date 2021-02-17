package com.project.collaborativeauthentication.android.view.main;

public interface HomeView
{
    void setVisibilityStopAuthenticationServiceOption(boolean visibility);
    void setVisibilityStartAuthenticationServiceOption(boolean visibility);
    void setVisibilityBluetoothOption(boolean visibility);
    void showTextOnToast(String text);

}
