package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartTaskView;

import java.util.LinkedList;
import com.project.collaborativeauthentication.R;

public class CustomStartMainPresenter extends CustomStartTaskPresenter
{
    private  static LinkedList<Session> queue = new LinkedList<>();

    public static int getSizeQueue()
    {
        return  queue.size();
    }

    public CustomStartMainPresenter(Navigator navigator, StartTaskView view) {
        super(navigator, view);
    }

    @Override
    protected LinkedList<Session> getQueue() {
        return queue;
    }

    @Override
    protected Session getNext() {
        SessionModel sessionModel = getModel().getSessionModel();
        Session session = sessionModel.getNextSessionWaitingForMain();
        return session;
    }

    @Override
    protected void pushNext(Session session)
    {
        SessionModel sessionModel = getModel().getSessionModel();
        sessionModel.pushSessionToMain(session);
    }

    @Override
    public void start()
    {
        start(R.id.action_startMainFragment_to_MainFragment);
    }

    @Override
    public void stop()
    {
        stop(R.id.action_startMainFragment_to_cancelledFragment);
    }

    @Override
    public int getButtonGoId() {
        return R.id.button_go_sm;
    }

    @Override
    public int getButtonStopId() {
        return R.id.button_cancel_sm;
    }

    @Override
    public int getTextViewLogin() {
        return R.id.textView_lnm;
    }

    @Override
    public int getTextViewAppName() {
        return R.id.textView_anm;
    }
}
