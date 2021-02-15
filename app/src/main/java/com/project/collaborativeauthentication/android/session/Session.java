package com.project.collaborativeauthentication.android.session;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Session
{

    public static final int MAXIMUM_NUMBER_OF_CONFLICTING_SESSIONS = 5;

    private static int nextSessionNumber       = 0;

    private ArrayList<String> names             = null;
    private ArrayList<Selection> selections     = null;
    private int                  sessionNumber  = 0;


    public Session()
    {
        this.selections      = null;
        this.names           = null;
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

    public void setNames(ArrayList<String> names)
    {
        this.names = names;
    }

    public void setSelections(ArrayList<Selection> selections )
    {
        this.selections = selections;
    }

    public ArrayList<Selection> getSelections() {
        return selections;
    }

    public ArrayList<String> getNames() {
        return names;
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
