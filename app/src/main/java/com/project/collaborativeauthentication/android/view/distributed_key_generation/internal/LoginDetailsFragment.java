package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.CustomLoginPresenter;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.LoginDetailsPresenter;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.LoginDetailsView;


public class LoginDetailsFragment extends CustomFragment implements LoginDetailsView {



    private final LoginDetailsPresenter presenter;
    private String applicationName = "";
    public LoginDetailsFragment()
    {
        this.presenter = new CustomLoginPresenter(getNavigator(), this);
    }


    public void setApplicationName(String applicationName)
    {
        this.applicationName = applicationName;
    }

    @Override
    public String getChosenLogin() {
        return ((EditText) getView().findViewById(R.id.editTextTextPersonName)).getText().toString();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        presenter.getApplicationName();
        return inflater.inflate(R.layout.fragment_login_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        ((Button) view.findViewById(R.id.button_submit_details)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.submit();
            }
        });

        ((TextView) view.findViewById(R.id.textView_app_name)).setText(applicationName);

    }
}