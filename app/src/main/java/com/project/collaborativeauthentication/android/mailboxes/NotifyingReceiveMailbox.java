package com.project.collaborativeauthentication.android.mailboxes;

public interface NotifyingReceiveMailbox
{
    void subscribe(Subscriber subscriber, int expectedNumberOfMessages);

}
