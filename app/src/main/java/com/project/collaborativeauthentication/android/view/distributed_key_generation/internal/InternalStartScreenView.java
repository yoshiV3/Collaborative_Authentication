package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartScreenView;

public interface InternalStartScreenView extends StartScreenView
{
    void setVisibilitySelectDevices(boolean visibility);
    void setVisibilitySelectWeights(boolean visibility);
    void setVisibilityMain(boolean visibility);
}
