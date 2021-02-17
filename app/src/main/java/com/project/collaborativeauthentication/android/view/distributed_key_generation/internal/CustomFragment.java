package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.Navigator;

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
