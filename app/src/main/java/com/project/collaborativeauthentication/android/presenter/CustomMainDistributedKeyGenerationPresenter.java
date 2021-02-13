package com.project.collaborativeauthentication.android.presenter;

import com.project.collaborativeauthentication.R;

public class CustomMainDistributedKeyGenerationPresenter implements MainDistributedKeyGenerationPresenter {

    private final Navigator   navigator;


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
