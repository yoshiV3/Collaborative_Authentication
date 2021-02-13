package com.project.collaborativeauthentication.android.presenter_implementations;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter_interfaces.MainDistributedKeyGenerationPresenter;
import com.project.collaborativeauthentication.android.presenter_interfaces.Navigator;

public class CustomMainDistributedKeyGenerationPresenter implements MainDistributedKeyGenerationPresenter {

    private final Navigator navigator;


    public CustomMainDistributedKeyGenerationPresenter(Navigator navigator)
    {
        this.navigator = navigator;
    }
    @Override
    public void cancel()
    {

        {
            navigator.navigate(R.id.cancel);
        }
    }
}
