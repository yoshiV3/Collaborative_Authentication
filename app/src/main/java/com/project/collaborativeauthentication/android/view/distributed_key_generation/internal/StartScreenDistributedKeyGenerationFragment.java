package com.project.collaborativeauthentication.android.view.distributed_key_generation.internal;

import android.os.Bundle;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.project.collaborativeauthentication.R;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.CustomStartScreenPresenter;
import com.project.collaborativeauthentication.android.presenter.distributed_key_generation.StartScreenPresenter;


public class StartScreenDistributedKeyGenerationFragment extends CustomFragment implements InternalStartScreenView {



    private static final String TEXT_DEVICES = "DEVICE SESSIONS: ";
    private static final String TEXT_WEIGHTS = "WEIGHT SESSIONS: ";
    private static final String TEXT_MAIN    = "MAIN SESSIONS: ";

    private boolean visibilityD = false;
    private boolean visibilityW = false;
    private boolean visibilityM = false;
    private boolean visibilityC = false;

    private final StartScreenPresenter presenter ;


    public StartScreenDistributedKeyGenerationFragment()
    {
        this.presenter = new CustomStartScreenPresenter(getNavigator(), this);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        presenter.getDisplayInformation();
        return inflater.inflate(R.layout.fragment_start_screen_distributed_key_generation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        ((Button) view.findViewById(R.id.button_new)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.newSession();
            }
        });
        ((Button) view.findViewById(R.id.button_resume_ds)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectDevices();
            }
        });
        ((Button) view.findViewById(R.id.button_resume_sw)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.selectWeights();
            }
        });
        ((Button) view.findViewById(R.id.button_resume_main)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.mainTask();
            }
        });
        redisplay();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void setVisibilitySelectDevices(boolean visibility)
    {
        visibilityD = visibility;
    }

    @Override
    public void setVisibilitySelectWeights(boolean visibility)
    {
        visibilityW = visibility;
    }

    @Override
    public void setVisibilityMain(boolean visibility)
    {
        visibilityM = visibility;
    }

    @Override
    public void setVisibilityClear(boolean visibilityClear)
    {
        visibilityC = visibilityClear;
    }

    @Override
    public void redisplay()
    {
        displayButton(R.id.button_clear, visibilityC);

        displayButtonAndText(R.id.button_resume_ds, R.id.textView_nb_ds, visibilityD, TEXT_DEVICES + String.valueOf(presenter.getNumberOfSessionsForD()));
        displayButtonAndText(R.id.button_resume_sw, R.id.textView_nb_ws, visibilityW, TEXT_WEIGHTS + String.valueOf(presenter.getNumberOfSessionsForW()));
        displayButtonAndText(R.id.button_resume_main, R.id.textView_nb_m, visibilityM, TEXT_MAIN + String.valueOf(presenter.getNumberOfSessionsForM()));
    }

    private void displayButtonAndText(int buttonId, int textId, boolean visible, String text )
    {
        View view = getView();
        TextView textView = ((TextView) view.findViewById(textId));
        Button    button  = ((Button) view.findViewById(buttonId));
        if (visible)
        {
            textView.setText(text);
        }
        else
        {
            textView.setVisibility(View.GONE);
            button.setVisibility(View.GONE);
        }

    }

    private void displayButton(int buttonId, boolean visibility)
    {
        View view = getView();
        Button    button  = ((Button) view.findViewById(buttonId));
        if (!visibility)
        {
            button.setVisibility(View.GONE);
        }
    }
}