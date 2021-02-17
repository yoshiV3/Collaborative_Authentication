package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CollaborativeAuthenticationModel;
import com.project.collaborativeauthentication.android.application_model.main_model.CustomSingletonAuthenticationModel;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.internal.InternalStartScreenView;
import com.project.collaborativeauthentication.R;

public class CustomStartScreenPresenter implements  StartScreenPresenter
{


    private final InternalStartScreenView           view;
    private final Navigator                         navigator;
    private final CollaborativeAuthenticationModel  model;

    public CustomStartScreenPresenter(Navigator navigator, InternalStartScreenView view)
    {

        this.navigator = navigator;
        this.view      = view;
        this.model     = CustomSingletonAuthenticationModel.getInstance();
    }

    @Override
    public void clear()
    {
        model.getSessionModel().clear();
        view.setVisibilityMain(false);
        view.setVisibilitySelectDevices(false);
        view.setVisibilitySelectWeights(false);
        view.setVisibilityClear(false);
        view.redisplay();
    }

    @Override
    public void selectDevices()
    {
        navigator.navigate(R.id.action_startScreenDistributedKeyGenerationFragment_to_startDeviceSelectionFragment);
    }

    @Override
    public void selectWeights()
    {
        navigator.navigate(R.id.action_startScreenDistributedKeyGenerationFragment_to_startSelectWeightFragment);
    }

    @Override
    public void mainTask()
    {
        navigator.navigate(R.id.action_startScreenDistributedKeyGenerationFragment_to_startMainFragment);
    }

    @Override
    public void newSession()
    {
        navigator.navigate(R.id.action_startScreenDistributedKeyGenerationFragment_to_loginDetailsFragment);
    }

    @Override
    public void getDisplayInformation()
    {
        SessionModel sessionModel = model.getSessionModel();
        int nbOfSessionsD         = sessionModel.getNumberOfWaitingSessionSelectDevices() + CustomStartSelectDevicesPresenter.getSizeQueue();
        int nbOfSessionsW         = sessionModel.getNumberOfWaitingSessionSelectWeights() + CustomStartSelectWeightsPresenter.getSizeQueue();
        int nbOfSessionsM         = sessionModel.getNumberOfWaitingSessionSelectMain()    + CustomStartMainPresenter.getSizeQueue();
        view.setVisibilitySelectDevices(nbOfSessionsD>0);
        view.setVisibilitySelectWeights(nbOfSessionsW>0);
        view.setVisibilityMain(nbOfSessionsM>0);
        view.setVisibilityClear(nbOfSessionsD + nbOfSessionsW + nbOfSessionsM > 0 );
    }

    @Override
    public int getNumberOfSessionsForD() {
        return model.getSessionModel().getNumberOfWaitingSessionSelectDevices();
    }

    @Override
    public int getNumberOfSessionsForW() {
        return model.getSessionModel().getNumberOfWaitingSessionSelectWeights();
    }

    @Override
    public int getNumberOfSessionsForM() {
        return model.getSessionModel().getNumberOfWaitingSessionSelectMain();
    }
}
