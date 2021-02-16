package com.project.collaborativeauthentication.android.presenter_interfaces;

import com.project.collaborativeauthentication.android.modules_implementations.authentication_service.Possibility;

import java.util.ArrayList;

public interface SelectWeightsPresenter
{

    void submit();

    ArrayList<Possibility> getSelectedDeviceNames();
}
