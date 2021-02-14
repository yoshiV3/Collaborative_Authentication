package com.project.collaborativeauthentication.android.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter_implementations.CustomSelectDevicesPresenter;
import com.project.collaborativeauthentication.android.presenter_interfaces.SelectDevicesPresenter;
import com.project.collaborativeauthentication.android.view_interfaces.SelectDevicesView;

import java.util.ArrayList;

public class SelectDevicesFragment extends CustomFragment implements SelectDevicesView {


    private RecyclerView                      pairedDevicesRecyclerView;
    private RecyclerView                      selectedDevicesRecyclerView;
    private CustomItemListRecyclerViewAdapter pairedDeviceAdapter;
    private CustomItemListRecyclerViewAdapter selectedDeviceAdapter;
    private SelectDevicesPresenter            presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        this.presenter = new CustomSelectDevicesPresenter(this, getNavigator());
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_devices, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        view.findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.submit();
            }
        });

        pairedDevicesRecyclerView =   (RecyclerView) view.findViewById(R.id.recycleview_paireddev);
        selectedDevicesRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView_sel);

        ArrayList<String> pairedDevices = new ArrayList<String>();
        pairedDeviceAdapter = new CustomItemListRecyclerViewAdapter(pairedDevices);
        ArrayList<String>    selectedDevices   = new ArrayList<String>();
        selectedDeviceAdapter = new CustomItemListRecyclerViewAdapter(selectedDevices);

        View.OnClickListener listenerPairedDevicesAdapter = new  View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                int position = pairedDevicesRecyclerView.getChildLayoutPosition(v);
                String item  = pairedDeviceAdapter.pop(position);
                presenter.selectedItemPairedDevices(item);
            }
        };
        pairedDeviceAdapter.setOnClickListener(listenerPairedDevicesAdapter);
        View.OnClickListener listenerSelectedDevicesAdapter = new  View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                int position = selectedDevicesRecyclerView.getChildLayoutPosition(v);
                String item  = selectedDeviceAdapter.pop(position);
                presenter.selectedItemSelectedDevices(item);
            }
        };
        selectedDeviceAdapter.setOnClickListener(listenerSelectedDevicesAdapter);
        selectedDevicesRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        pairedDevicesRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        selectedDevicesRecyclerView.setAdapter(selectedDeviceAdapter);
        pairedDevicesRecyclerView.setAdapter(pairedDeviceAdapter);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        this.presenter.getItemsPairedDevices();
        super.onStart();
    }

    @Override
    public void pushItemPairedDevices(String item)
    {
        this.pairedDeviceAdapter.add(item);
    }

    @Override
    public void pushItemSelectedDevices(String item)
    {
        this.selectedDeviceAdapter.add(item);
    }

    @Override
    public void pushItemListPairedDevices(ArrayList<String> items)
    {
        this.pairedDeviceAdapter.addItemList(items);
    }

    @Override
    public ArrayList<String> getSelectedItems() {
        return this.selectedDeviceAdapter.getItems();
    }
}