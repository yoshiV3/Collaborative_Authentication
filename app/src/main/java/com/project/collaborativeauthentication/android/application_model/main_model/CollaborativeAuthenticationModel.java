package com.project.collaborativeauthentication.android.application_model.main_model;

import com.project.collaborativeauthentication.android.application_model.authentication_service.AuthenticationEntryPointModificationModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.AuthenticationEntryPointStatusModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.AuthenticationServiceStatusModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.data.remote.NetworkStatusModel;

public interface CollaborativeAuthenticationModel
{

    NetworkStatusModel  getNetworkStatusModel();

    AuthenticationEntryPointStatusModel       getAuthenticationEntryPointStatusModel();
    AuthenticationEntryPointModificationModel getAuthenticationEntryPointModificationModel();

    AuthenticationServiceStatusModel getAuthenticationServiceStatusModel();


    SessionModel getSessionModel();

}
