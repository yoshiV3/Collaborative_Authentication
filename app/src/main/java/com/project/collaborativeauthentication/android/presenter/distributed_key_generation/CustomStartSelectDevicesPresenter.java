package com.project.collaborativeauthentication.android.presenter.distributed_key_generation;

import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.view.distributed_key_generation.StartTaskView;

import java.util.LinkedList;
import com.project.collaborativeauthentication.R;

public class CustomStartSelectDevicesPresenter extends  CustomStartTaskPresenter
{

    private  static LinkedList<Session> queue = new LinkedList<>();

    public static int getSizeQueue()
    {
        return  queue.size();
    }

    public CustomStartSelectDevicesPresenter(Navigator navigator, StartTaskView view)
    {
        super(navigator, view);
    }

    @Override
    protected LinkedList<Session> getQueue() {
        return queue;
    }

    @Override
    protected Session getNext()
    {
        SessionModel sessionModel = getModel().getSessionModel();
        Session session = sessionModel.getNextSessionWaitingForSelectDevices();
        return session;
    }

    @Override
    protected void pushNext(Session session)
    {
        SessionModel sessionModel = getModel().getSessionModel();
        sessionModel.pushSessionToSelectDevices(session);
    }

    @Override
    public void start()
    {
        start(R.id.start_sel);
    }

    @Override
    public void stop()
    {
        stop(R.id.cancel_select_devices);
    }

    @Override
    public int getButtonGoId() {
        return R.id.button;
    }

    @Override
    public int getButtonStopId() {
        return R.id.button_cancel_ss;
    }

    @Override
    public int getTextViewLogin() {
        return R.id.textView_lnss;
    }

    @Override
    public int getTextViewAppName() {
        return R.id.textView_anss;
    }


}
