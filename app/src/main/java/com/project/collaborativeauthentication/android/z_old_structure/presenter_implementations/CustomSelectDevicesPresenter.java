package com.project.collaborativeauthentication.android.z_old_structure.presenter_implementations;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.z_old_structure.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.Navigator;
import com.project.collaborativeauthentication.android.z_old_structure.presenter_interfaces.SelectDevicesPresenter;
import com.project.collaborativeauthentication.android.z_old_structure.view_interfaces.SelectDevicesView;

import java.util.ArrayList;

public class CustomSelectDevicesPresenter implements SelectDevicesPresenter
{
    private final SelectDevicesView view;
    private final Navigator navigator;
    private final SessionInformationModuleConnector sessionConnector;

    public CustomSelectDevicesPresenter(SelectDevicesView view, Navigator navigator)
    {
        this.view               = view;
        this.navigator          = navigator;
        this.sessionConnector   = CustomSingletonSessionInformationModuleConnector.getInstance();
        sessionConnector.createNewSession();
    }

    @Override
    public void selectedItemPairedDevices(Possibility item)
    {
        view.pushItemSelectedDevices(item);
    }

    @Override
    public void selectedItemSelectedDevices(Possibility item)
    {
        view.pushItemPairedDevices(item);
    }

    @Override
    public void getItemsPairedDevices()
    {
        view.pushItemListPairedDevices(this.sessionConnector.getPairedDevices());
    }

    @Override
    public void submit()
    {
        ArrayList<Possibility> choices = view.getSelectedItems();
        this.sessionConnector.storeSelectedDevices(choices);
        navigator.navigate(R.id.submit);
    }
}
