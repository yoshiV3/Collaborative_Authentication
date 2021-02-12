package com.project.collaborativeauthentication.android.presenter;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.connector_implementation.AndroidBluetoothInformationConnector;
import com.project.collaborativeauthentication.android.connector_interfaces.BluetoothInformationConnector;

public class CustomSelectDevicesPresenter implements SelectDevicesPresenter
{
    private final SelectDevicesView  view;
    private final BluetoothInformationConnector bluetoothConnector;
    private final Navigator navigator;

    public CustomSelectDevicesPresenter(SelectDevicesView view, Navigator navigator)
    {
        this.view = view;
        this.bluetoothConnector = new AndroidBluetoothInformationConnector();
        this.navigator          = navigator;
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
        navigator.navigate(R.id.submit);
    }


}
