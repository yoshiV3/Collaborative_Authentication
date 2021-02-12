package com.project.collaborativeauthentication.android.presenter;

import com.project.collaborativeauthentication.R;

public class CustomNavigationPresenter implements NavigationPresenter
{


    private static final String MESSAGE_BACK_SELECT = "The distributed key generation process was cancelled.";
    private static final String MESSAGE_BACK_MAIN   = "Process not yet ready";
    private static final String MESSAGE_ERROR       = "Some error occurred.";
    private final Locator         locator;
    private final NavigationView  view;

    public CustomNavigationPresenter(NavigationView view, Locator locator)
    {
        this.locator = locator;
        this.view    = view;
    }
    @Override
    public void onBackPressed()
    {
        int currentPosition = locator.getCurrentPosition();
        switch (currentPosition)
        {
            case R.id.MainFragment:
                this.view.showTextOnToast(MESSAGE_BACK_MAIN);
                this.view.returnToMain();
                break;
            case R.id.SelectFragment:
                this.view.showTextOnToast(MESSAGE_BACK_SELECT);
                break;
            case R.id.cancelledFragment:
                this.view.returnToMain();
                break;
            default:
                this.view.showTextOnToast(MESSAGE_ERROR);
                this.view.returnToMain();
        }
    }
}
