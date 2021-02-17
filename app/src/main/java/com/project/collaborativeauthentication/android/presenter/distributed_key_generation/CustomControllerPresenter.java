package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.ControllerView;


public class CustomControllerPresenter implements ControllerPresenter
{


    private static final String MESSAGE_CANCEL              = "The distributed key generation process was cancelled.";
    private static final String MESSAGE_BACK_NOT           = "Process not yet ready";
    private static final String MESSAGE_ERROR               = "Some error occurred.";

    private final Locator         locator;
    private final ControllerView  view;



    public CustomControllerPresenter(ControllerView view, Locator locator)
    {
        this.locator = locator;
        this.view    = view;

    }
    @Override
    public void onBackPressed()
    {
        int currentPosition = locator.getCurrentPosition();
        switch (currentPosition)
        {
            case R.id.MainFragment:
            case R.id.startDeviceSelectionFragment:
            case R.id.startMainFragment:
            case R.id.startSelectWeightFragment:
                this.view.showTextOnToast(MESSAGE_BACK_NOT);
                break;
            case R.id.SelectFragment:
            case R.id.startScreenDistributedKeyGenerationFragment:
            case R.id.loginDetailsFragment:
            case R.id.cancelledFragment:
            case R.id.SelectWeights:
                this.view.showTextOnToast(MESSAGE_CANCEL);
                this.view.returnToMain();
                break;
            default:
                this.view.showTextOnToast(MESSAGE_ERROR);
                this.view.returnToMain();
        }
    }
}
