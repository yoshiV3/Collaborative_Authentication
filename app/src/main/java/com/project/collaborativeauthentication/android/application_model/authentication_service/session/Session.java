package com.project.collaborativeauthentication.android.application_model.authentication_service.session;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Session
{





    private ArrayList<Possibility>    choices          = null;

    private final String applicationName;
    private final  String login;



    public Session(String applicationName, String login)
    {
        this.login = login;
        this.choices         =   null;
        this.applicationName = applicationName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getLogin() {
        return login;
    }

    public void setChoices(ArrayList<Possibility> choices) {
        this.choices = choices;
    }


    public ArrayList<Possibility> getChoices() {
        return choices;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (! (obj instanceof  Session))
        {
            return false;
        }
        Session other = (Session) obj;
        return other.getApplicationName().equals(applicationName) && other.getLogin().equals(login);
    }
}
