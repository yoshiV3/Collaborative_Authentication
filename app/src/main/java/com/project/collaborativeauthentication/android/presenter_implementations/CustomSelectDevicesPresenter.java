package com.project.collaborativeauthentication.android.presenter_implementations;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.connector_implementation.AndroidBluetoothInformationConnector;
import com.project.collaborativeauthentication.android.connector_implementation.CustomSingletonSessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothInformationConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.SessionInformationModuleConnector;
import com.project.collaborativeauthentication.android.presenter_interfaces.Navigator;
import com.project.collaborativeauthentication.android.presenter_interfaces.SelectDevicesPresenter;
import com.project.collaborativeauthentication.android.view_interfaces.SelectDevicesView;

import java.util.ArrayList;

public class CustomSelectDevicesPresenter implements SelectDevicesPresenter
{
    private final SelectDevicesView view;
    private final BluetoothInformationConnector bluetoothConnector;
    private final Navigator navigator;
    private final SessionInformationModuleConnector sessionConnector;

    public CustomSelectDevicesPresenter(SelectDevicesView view, Navigator navigator)
    {
        this.view = view;
        this.bluetoothConnector = new AndroidBluetoothInformationConnector();
        this.navigator          = navigator;
        this.sessionConnector   = CustomSingletonSessionInformationModuleConnector.getInstance();
    }

    @Override
    public void selectedItemPairedDevices(String item)
    {
        view.pushItemSelectedDevices(item);
    }

    @Override
    public void selectedItemSelectedDevices(String item)
    {
        view.pushItemPairedDevices(item);
    }

    @Override
    public void getItemsPairedDevices()
    {
        view.pushItemListPairedDevices(this.bluetoothConnector.getPairedBluetoothDevicesNames());
    }

    @Override
    public void submit()
    {
        ArrayList<String> names = view.getSelectedItems();
        this.sessionConnector.storeSelectedDevices(names);
        navigator.navigate(R.id.submit);
    }
}
