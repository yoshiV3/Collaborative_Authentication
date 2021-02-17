package com.project.collaborativeauthentication.android.view.authentication_service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import com.project.collaborativeauthentication.R;

import com.project.collaborativeauthentication.android.Constants;
import com.project.collaborativeauthentication.android.view.main.MainActivity;
import com.project.collaborativeauthentication.android.application_model.android_framework.CustomBluetoothBroadcastReceiver;
import com.project.collaborativeauthentication.android.presenter.authentication_service.AuthenticationEntryPointPresenter;
import com.project.collaborativeauthentication.android.presenter.authentication_service.CustomAuthenticationEntryPointPresenter;

public class AuthenticationEntryPointForegroundService extends Service implements AuthenticationEntryPointForegroundServiceView {


    private static final String                  CHANNEL_ID = "AuthenticationService";
    private final AuthenticationEntryPointPresenter presenter;
    private final CustomBluetoothBroadcastReceiver receiver;


    private  NotificationManager                    manager;


    public AuthenticationEntryPointForegroundService()
    {
        this.presenter = new CustomAuthenticationEntryPointPresenter(this);
        this.receiver  = new CustomBluetoothBroadcastReceiver(presenter);
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        this.manager   =     getSystemService(NotificationManager.class);
        registerReceiver();
    }

    @Override
    public void onDestroy()
    {
        unregisterReceiver(this.receiver);
        super.onDestroy();
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        registerReceiver(this.receiver, filter);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        if (intent != null)
        {
            String action = intent.getAction();
            switch (action)
            {
                case Constants.START_ACTION:
                    presenter.onStartCommand();
                    break;
                case Constants.STOP_ACTION:
                    presenter.onStopCommand();
                    break;
                default:
                    presenter.onUnsupportedAction();
            }
        }
        return START_REDELIVER_INTENT;
    }


    private void createNotificationChannel() {
        NotificationChannel serviceChannel = new NotificationChannel(CHANNEL_ID, "ServiceChannel", NotificationManager.IMPORTANCE_DEFAULT);
        manager.createNotificationChannel(serviceChannel);
    }

    @Override
    public void startInForeground()
    {
        Notification notification = getAuthenticationServiceNotification();
        startForeground(1, notification);
    }

    @Override
    public void stop()
    {
        stopForeground(true);
        stopSelf();
    }

    @Override
    public void coldStop()
    {
        stopSelf();
    }

    @Override
    public void notifyError()
    {
        Notification notification = getNotificationAutoCloseNoActivity(R.string.errornot);
        manager.notify(3,notification);
    }

    @Override
    public void notifyWithoutStop()
    {
        Notification notification = getNotificationAutoCloseNoActivity(R.string.errornotnostop);
        manager.notify(3,notification);
    }

    @Override
    public void notifyStartBluetooth()
    {
        Notification notification = getBluetoothStartNotification();
        manager.notify(2,notification);
    }


    private Notification getBluetoothStartNotification() {
        return getNotificationAutoCloseNoActivity(R.string.startNotificationText);
    }

    @Override
    public void notifyPausedBluetooth()
    {
        Notification notification = getBluetoothPauseNotification();
        manager.notify(2,notification);
    }

    private Notification getBluetoothPauseNotification()
    {
        return getNotificationAutoCloseNoActivity(R.string.pauseNotificationText);

    }


    private Notification getAuthenticationServiceNotification() {
        Intent notificationIntent   = new Intent(this, MainActivity.class);
        notificationIntent.setAction(Intent.ACTION_MAIN);
        notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,0);
        return getNotification(pendingIntent, R.string.notificationText);
    }


    private Notification getNotificationAutoCloseNoActivity(int notificationText)
    {
        createNotificationChannel();
        Notification resultNotification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(getString(notificationText))
                .setSmallIcon(R.drawable.ic_notification_asset)
                .setAutoCancel(true)
                .build();
        return resultNotification;
    }

    private Notification getNotification(PendingIntent pendingIntent, int notificationText)
    {
        createNotificationChannel();
        Notification resultNotification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(getString(R.string.app_name))
                .setContentText(getString(notificationText))
                .setContentIntent(pendingIntent)
                .build();
        return resultNotification;
    }
}