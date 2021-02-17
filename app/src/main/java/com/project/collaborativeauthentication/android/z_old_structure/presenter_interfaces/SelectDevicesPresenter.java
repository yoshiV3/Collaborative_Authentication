package com.project.collaborativeauthentication.android.z_old_structure.presenter_interfaces;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;

public interface SelectDevicesPresenter
{
    void selectedItemPairedDevices(Possibility item);
    void selectedItemSelectedDevices(Possibility item);
    void getItemsPairedDevices();
    void submit();
}
