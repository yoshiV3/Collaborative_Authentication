package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartTaskView;
import com.project.collaborativeauthentication.R;

import java.util.LinkedList;

public class CustomStartSelectWeightsPresenter extends CustomStartTaskPresenter
{


    private  static LinkedList<Session> queue = new LinkedList<>();


    public static int getSizeQueue()
    {
        return  queue.size();
    }

    public CustomStartSelectWeightsPresenter(Navigator navigator, StartTaskView view)
    {
        super(navigator, view);
    }

    @Override
    public void start()
    {
        start(R.id.action_startSelectWeightFragment_to_SelectWeights);
    }

    @Override
    public void stop()
    {
        stop(R.id.action_startSelectWeightFragment_to_cancelledFragment);
    }

    @Override
    public int getButtonGoId() {
        return R.id.button_go_sw;
    }

    @Override
    public int getButtonStopId() {
        return R.id.button_cancel_sw;
    }

    @Override
    public int getTextViewLogin() {
        return R.id.textView_lnsw;
    }

    @Override
    public int getTextViewAppName() {
        return R.id.textView_answ;
    }


    @Override
    protected LinkedList<Session> getQueue() {
        return queue;
    }

    @Override
    protected Session getNext() {
        SessionModel sessionModel = getModel().getSessionModel();
        Session session = sessionModel.getNextSessionWaitingForSelectWeights();
        return session;
    }

    @Override
    protected void pushNext(Session session)
    {
        SessionModel sessionModel = getModel().getSessionModel();
        sessionModel.pushSessionToSelectWeights(session);
    }
}
