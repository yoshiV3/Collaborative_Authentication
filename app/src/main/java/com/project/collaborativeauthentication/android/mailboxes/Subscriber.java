package com.project.collaborativeauthentication.android.mailboxes;

public interface Subscriber
{
    void notifyReceivedAll();
    void notifyNumberOfReceivedMessages(int number);
}
