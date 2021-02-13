package com.project.collaborativeauthentication.android.presenter_interfaces;

public interface SelectDevicesPresenter
{
    void selectedItemPairedDevices(String item);
    void selectedItemSelectedDevices(String item);
    void getItemsPairedDevices();
    void submit();
}
