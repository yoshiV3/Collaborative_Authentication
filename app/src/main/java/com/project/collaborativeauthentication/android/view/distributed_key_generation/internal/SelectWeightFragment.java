package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;
import com.project.collaborativeauthentication.android.z_old_structure.presenter_implementations.CustomSelectWeightsPresenter;
import com.project.collaborativeauthentication.android.z_old_structure.presenter_interfaces.SelectWeightsPresenter;
import com.project.collaborativeauthentication.android.z_old_structure.view_interfaces.SelectWeightsView;

import java.util.ArrayList;


public class SelectWeightFragment extends CustomFragment implements SelectWeightsView {


    private RecyclerView selectWeightsRecyclerView;
    private SelectWeightsPresenter presenter;
    private CustomWeightListViewAdapter adapter;

    public SelectWeightFragment()
    {
        this.presenter = new CustomSelectWeightsPresenter(this, getNavigator());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_select_weight, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        view.findViewById(R.id.button_submit_weights).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.submit();
            }
        });


        this.selectWeightsRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_weights);


        ArrayList<Possibility> selectedDevices = new ArrayList<>();
        this.adapter = new CustomWeightListViewAdapter(selectedDevices);

        selectWeightsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        selectWeightsRecyclerView.setAdapter(adapter);




        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        adapter.addItemList(presenter.getSelectedDeviceNames());
        super.onStart();
    }
}