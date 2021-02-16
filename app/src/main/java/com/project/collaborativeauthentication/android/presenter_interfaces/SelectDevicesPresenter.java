package com.project.collaborativeauthentication.android.presenter_interfaces;

import com.project.collaborativeauthentication.android.modules_implementations.authentication_service.Possibility;

public interface SelectDevicesPresenter
{
    void selectedItemPairedDevices(Possibility item);
    void selectedItemSelectedDevices(Possibility item);
    void getItemsPairedDevices();
    void submit();
}
