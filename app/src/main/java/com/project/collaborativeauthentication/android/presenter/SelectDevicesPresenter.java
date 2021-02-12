package com.project.collaborativeauthentication.android.presenter;

public interface SelectDevicesPresenter
{
    void selectedItemPairedDevices(String item);
    void selectedItemSelectedDevices(String item);
    void getItemsPairedDevices();
    void submit();
}
