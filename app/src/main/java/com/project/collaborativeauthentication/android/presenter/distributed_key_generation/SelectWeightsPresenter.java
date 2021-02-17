package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;

import java.util.ArrayList;

public interface SelectWeightsPresenter
{

    void submit();

    ArrayList<Possibility> getSelectedDeviceNames();
}
