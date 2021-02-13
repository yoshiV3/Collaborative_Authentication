package com.project.collaborativeauthentication.android.presenter;

public class CustomAuthenticationServicePresenter implements AuthenticationServicePresenter
{

    private final AuthenticationServiceView view;

    public  CustomAuthenticationServicePresenter(AuthenticationServiceView view)
    {
        this.view = view;
    }

    @Override
    public void onStartCommand()
    {
        view.startInForeground();
    }

    @Override
    public void onStopCommand()
    {
        view.stop();
    }

    @Override
    public void onUnsupportedAction()
    {

    }
}
