package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;

public interface SelectDevicesPresenter
{
    void selectedItemPairedDevices(Possibility item);
    void selectedItemSelectedDevices(Possibility item);
    void getItemsPairedDevices();
    void submit();
}
