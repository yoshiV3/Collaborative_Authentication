package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;
import android.widget.Toast;


import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.CustomControllerPresenter;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.ControllerPresenter;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.ControllerView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;


public class DistributedKeyGenerationActivity extends AppCompatActivity  implements ControllerView {


    private final ControllerPresenter navigationPresenter;

    public DistributedKeyGenerationActivity()
    {
        this.navigationPresenter = new CustomControllerPresenter(this,new ControllerPresenter.Locator() {
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