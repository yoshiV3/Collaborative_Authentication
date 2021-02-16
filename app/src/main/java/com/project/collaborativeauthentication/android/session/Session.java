package com.project.collaborativeauthentication.android.session;

import androidx.annotation.Nullable;

import com.project.collaborativeauthentication.android.modules_implementations.authentication_service.Possibility;

import java.util.ArrayList;

public class Session
{

    public static final int MAXIMUM_NUMBER_OF_CONFLICTING_SESSIONS = 5;

    private static int nextSessionNumber       = 0;

    private ArrayList<Possibility>    choices       = null;
    private int                  sessionNumber  = 0;


    public Session()
    {
        this.choices         =   null;
        this.sessionNumber   = nextSessionNumber;
        nextSessionNumber    = nextSessionNumber +1;
        if (nextSessionNumber > MAXIMUM_NUMBER_OF_CONFLICTING_SESSIONS)
        {
            nextSessionNumber = 0;
        }
    }

    public int getSessionNumber() {
        return sessionNumber;
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
        return other.getSessionNumber() == this.getSessionNumber();
    }
}
