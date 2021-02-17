package com.project.collaborativeauthentication.android.presenter.authentication_service;
import android.util.Log;

import com.project.collaborativeauthentication.android.Constants;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;
import com.project.collaborativeauthentication.android.view.authentication_service.AuthenticationEntryPointForegroundServiceView;

public class CustomAuthenticationEntryPointPresenter implements AuthenticationEntryPointPresenter
{

    private final AuthenticationEntryPointForegroundServiceView view;

    private final CollaborativeAuthenticationModel model = CustomSingletonAuthenticationModel.getInstance();



    public CustomAuthenticationEntryPointPresenter(AuthenticationEntryPointForegroundServiceView view)
    {
        this.view = view;
    }

    @Override
    public void onStartCommand()
    {
        boolean success = model.getAuthenticationEntryPointModificationModel().notifyStartEntryPoint();
        if (success)
        {
            view.startInForeground();
        }
        else
        {
            Log.i("CAM", "Stopped  during starting entry point");
            view.notifyError();
            view.coldStop();
        }
    }

    @Override
    public void onStopCommand()
    {
        model.getAuthenticationEntryPointModificationModel().notifyStopEntryPoint();
        view.stop();
    }

    @Override
    public void onUnsupportedAction()
    {
        view.notifyErrorWithoutStop();
    }

    @Override
    public void notifyStateBluetoothChanged()
    {
       int result =   model.getAuthenticationEntryPointModificationModel().notifyBluetoothChanged();
       switch (result)
       {
           case Constants.BLUETOOTH_CHANGED_ON:
               this.view.notifyStartBluetooth();
               break;
           case Constants.BLUETOOTH_CHANGED_OFF:
               this.view.notifyPausedBluetooth();
               break;
           case Constants.DONE:
               break;
           default:
               Log.i("CAM", "Stopped  during change of bluetooth change");
               this.view.notifyError();
               this.view.stop();
       }

    }
}
