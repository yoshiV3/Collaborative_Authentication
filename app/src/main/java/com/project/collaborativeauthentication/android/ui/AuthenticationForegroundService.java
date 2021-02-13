package com.project.collaborativeauthentication.android.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import com.project.collaborativeauthentication.R;

import com.project.collaborativeauthentication.android.Constants;
import com.project.collaborativeauthentication.android.presenter.AuthenticationServicePresenter;
import com.project.collaborativeauthentication.android.presenter.AuthenticationServiceView;
import com.project.collaborativeauthentication.android.presenter.CustomAuthenticationServicePresenter;

public class AuthenticationForegroundService extends Service implements AuthenticationServiceView {


    private static final String CHANNEL_ID = "AuthenticationService";



    private final AuthenticationServicePresenter presenter;
    public AuthenticationForegroundService()
    {
        this.presenter = new CustomAuthenticationServicePresenter(this);
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
        NotificationManager manager        = getSystemService(NotificationManager.class);
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


    private Notification getAuthenticationServiceNotification() {
        Intent notificationIntent   = new Intent(this, MainActivity.class);
        notificationIntent.setAction(Intent.ACTION_MAIN);
        notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,0);
        return getNotification(pendingIntent, R.string.notificationText);
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