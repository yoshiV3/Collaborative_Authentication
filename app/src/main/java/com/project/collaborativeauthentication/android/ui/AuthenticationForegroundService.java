package com.project.collaborativeauthentication.android.ui;

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
import com.project.collaborativeauthentication.android.modules_implementations.information.CustomBluetoothBroadcastReceiver;
import com.project.collaborativeauthentication.android.presenter_interfaces.AuthenticationServicePresenter;
import com.project.collaborativeauthentication.android.view_interfaces.AuthenticationServiceView;
import com.project.collaborativeauthentication.android.presenter_implementations.CustomAuthenticationServicePresenter;

public class AuthenticationForegroundService extends Service implements AuthenticationServiceView {


    private static final String                    CHANNEL_ID = "AuthenticationService";
    private final AuthenticationServicePresenter   presenter;
    private final CustomBluetoothBroadcastReceiver receiver;
    private final NotificationManager              manager;


    public AuthenticationForegroundService()
    {
        this.manager   =    getSystemService(NotificationManager.class);
        this.presenter = new CustomAuthenticationServicePresenter(this);
        this.receiver  = new CustomBluetoothBroadcastReceiver(this.presenter);
    }

    @Override
    public void onCreate()
    {
        registerReceiver();
        super.onCreate();
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
    public void notifyStartBluetooth()
    {
        Notification notification = getStartNotification();
        notify(notification);
        manager.notify(2,notification);
    }

    private void notify(Notification notification)
    {

    }

    private Notification getStartNotification() {
        Intent notificationIntent   = new Intent(this, MainActivity.class);
        notificationIntent.setAction(Intent.ACTION_MAIN);
        notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 1, notificationIntent,0);
        return getNotificationAutoCloseNoActivity( R.string.startNotificationText);
    }

    @Override
    public void notifyPausedBluetooth()
    {

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