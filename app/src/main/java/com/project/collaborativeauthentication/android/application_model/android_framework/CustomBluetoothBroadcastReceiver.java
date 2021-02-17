package com.project.collaborativeauthentication.android.application_model.android_framework;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.project.collaborativeauthentication.android.presenter.authentication_service.AuthenticationEntryPointPresenter;

public class CustomBluetoothBroadcastReceiver extends BroadcastReceiver
{
    private final AuthenticationEntryPointPresenter presenter;

    public CustomBluetoothBroadcastReceiver(AuthenticationEntryPointPresenter presenter)
    {
        this.presenter = presenter;
    }
    @Override
    public void onReceive(Context context, Intent intent)
    {
        if(intent != null)
        {
            String action = intent.getAction();
            if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED))
            {
                presenter.notifyStateBluetoothChanged();
            }

        }
    }
}
