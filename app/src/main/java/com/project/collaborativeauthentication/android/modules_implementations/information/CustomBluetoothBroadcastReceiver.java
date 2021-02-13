package com.project.collaborativeauthentication.android.modules_implementations.information;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.project.collaborativeauthentication.android.presenter_interfaces.AuthenticationServicePresenter;

public class CustomBluetoothBroadcastReceiver extends BroadcastReceiver
{
    private final AuthenticationServicePresenter presenter;

    public CustomBluetoothBroadcastReceiver(AuthenticationServicePresenter presenter)
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
