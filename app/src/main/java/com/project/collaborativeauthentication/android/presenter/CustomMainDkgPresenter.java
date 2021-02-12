package com.project.collaborativeauthentication.android.presenter;

import com.project.collaborativeauthentication.R;

public class CustomMainDkgPresenter implements MainDkgPresenter{

    private final Navigator   navigator;


    public CustomMainDkgPresenter( Navigator navigator)
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
