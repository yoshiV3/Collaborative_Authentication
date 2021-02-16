package com.project.collaborativeauthentication.android.presenter_implementations;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.connector_implementation.CustomSingletonSessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.presenter_interfaces.NavigationPresenter;
import com.project.collaborativeauthentication.android.view_interfaces.NavigationView;

public class CustomNavigationPresenter implements NavigationPresenter
{


    private static final String MESSAGE_BACK_SELECT_DEVICES = "The distributed key generation process was cancelled during device selection.";
    private static final String MESSAGE_BACK_SELECT_WEIGHTS = "The distributed key generation process was cancelled during device selection.";
    private static final String MESSAGE_BACK_MAIN           = "Process not yet ready";
    private static final String MESSAGE_ERROR               = "Some error occurred.";

    private final Locator         locator;
    private final NavigationView  view;

    private final static SessionInformationModuleConnector sessionInformationModuleConnector = CustomSingletonSessionInformationModuleConnector.getInstance();

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
                break;
            case R.id.SelectFragment:
                this.view.showTextOnToast(MESSAGE_BACK_SELECT_DEVICES);
                sessionInformationModuleConnector.stopSession();
                this.view.returnToMain();
                break;
            case R.id.SelectWeights:
                this.view.showTextOnToast(MESSAGE_BACK_SELECT_WEIGHTS);
                sessionInformationModuleConnector.stopSession();
                this.view.returnToMain();
            case R.id.cancelledFragment:
                this.view.returnToMain();
                break;
            default:
                this.view.showTextOnToast(MESSAGE_ERROR);
                this.view.returnToMain();
        }
    }
}
