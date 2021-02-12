package com.project.collaborativeauthentication.android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.CustomNavigationPresenter;
import com.project.collaborativeauthentication.android.presenter.NavigationPresenter;
import com.project.collaborativeauthentication.android.presenter.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;


public class DistributedKeyGenerationActivity extends AppCompatActivity  implements NavigationView {


    private final NavigationPresenter navigationPresenter;

    public DistributedKeyGenerationActivity()
    {
        this.navigationPresenter = new CustomNavigationPresenter(this,new NavigationPresenter.Locator() {
            @Override
            public int getCurrentPosition() {
                return NavHostFragment.findNavController(getSupportFragmentManager().getFragments().get(0)).getCurrentDestination().getId();

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distributed_key_generation);
    }

    @Override
    public void onBackPressed()
    {
        this.navigationPresenter.onBackPressed();
    }

    @Override
    public void returnToMain()
    {
        this.finish();
    }

    @Override
    public void showTextOnToast(String text)
    {
        Toast toast = new Toast(this);
        toast.setText(text);
        toast.show();
    }
}