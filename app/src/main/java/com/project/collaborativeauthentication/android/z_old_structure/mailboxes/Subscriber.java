package com.project.collaborativeauthentication.android.z_old_structure.mailboxes;

public interface Subscriber
{
    void notifyReceivedAll();
    void notifyNumberOfReceivedMessages(int number);
}
