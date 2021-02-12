package com.project.collaborativeauthentication.android.connector_implementation;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.project.collaborativeauthentication.android.SelectDevicesFragment;
import com.project.collaborativeauthentication.android.presenter.Navigator;

public abstract class CustomFragment extends Fragment
{
    protected Navigator getNavigator()
    {
        return new Navigator() {
            @Override
            public void navigate(int target) {
                NavHostFragment.findNavController(CustomFragment.this).navigate(target);
            }
        };
    }
}
