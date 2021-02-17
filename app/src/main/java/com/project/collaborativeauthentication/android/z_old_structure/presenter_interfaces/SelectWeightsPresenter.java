package com.project.collaborativeauthentication.android.z_old_structure.presenter_interfaces;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;

import java.util.ArrayList;

public interface SelectWeightsPresenter
{

    void submit();

    ArrayList<Possibility> getSelectedDeviceNames();
}
