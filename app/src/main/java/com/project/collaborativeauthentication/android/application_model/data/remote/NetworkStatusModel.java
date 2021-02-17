package com.project.collaborativeauthentication.android.application_model.data.remote;

public interface NetworkStatusModel
{
   boolean isNetworkAvailable();
   boolean isNetworkEnabled();

   boolean canEnableNetwork();
}
