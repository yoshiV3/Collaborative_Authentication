package com.project.collaborativeauthentication.android.application_model.main_model;

import com.project.collaborativeauthentication.android.Constants;
import com.project.collaborativeauthentication.android.application_model.android_framework.Device;
import com.project.collaborativeauthentication.android.application_model.authentication_service.AuthenticationEntryPointModificationModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.AuthenticationEntryPointStatusModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.AuthenticationService;
import com.project.collaborativeauthentication.android.application_model.authentication_service.AuthenticationServiceStatusModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.EntryPoint;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Session;
import com.project.collaborativeauthentication.android.application_model.authentication_service.SessionModel;
import com.project.collaborativeauthentication.android.application_model.data.remote.Network;
import com.project.collaborativeauthentication.android.application_model.data.remote.NetworkStatusModel;
import com.project.collaborativeauthentication.android.application_model.authentication_service.session.Possibility;

import java.util.ArrayList;

public class CustomSingletonAuthenticationModel implements CollaborativeAuthenticationModel
{
    private static CustomSingletonAuthenticationModel instance = null;
    public static  CustomSingletonAuthenticationModel getInstance()
    {
        if (instance == null)
        {
            instance = new CustomSingletonAuthenticationModel();
        }
        return instance;
    }


    private EntryPoint              entryPoint;
    private Network                 network;
    private AuthenticationService   service;


    private CustomSingletonAuthenticationModel()
    {
        entryPoint = new EntryPoint();
        network    = new Network();
        service    = new AuthenticationService();
    }

    @Override
    public NetworkStatusModel getNetworkStatusModel()
    {

        return new NetworkStatusModel() {
            @Override
            public boolean isNetworkAvailable() {
                return network.isNetworkAvailable();
            }

            @Override
            public boolean isNetworkEnabled() {
                return network.isNetworkEnabled();
            }

            @Override
            public boolean canEnableNetwork() {
                return network.isNetworkAvailable() && !network.isNetworkEnabled();
            }
        };
    }


    @Override
    public AuthenticationEntryPointStatusModel getAuthenticationEntryPointStatusModel()
    {
        return new AuthenticationEntryPointStatusModel() {
            @Override
            public boolean isAuthenticationEntryPointActive() {
                return entryPoint.isEntryPointReady();
            }

            @Override
            public boolean isAuthenticationEntryPointSleeping() {
                return entryPoint.isEntryPointPaused();
            }

            @Override
            public boolean isAuthenticationEntryPointStopped() {
                return entryPoint.isEntryPointOff();
            }

            @Override
            public boolean canLaunchEntryPoint() {
                return entryPoint.isEntryPointOff();
            }

            @Override
            public boolean canStopEntryPoint() {
                return entryPoint.isEntryPointReady() || entryPoint.isEntryPointPaused();
            }
        };
    }

    @Override
    public AuthenticationEntryPointModificationModel getAuthenticationEntryPointModificationModel() {
        return new AuthenticationEntryPointModificationModel() {
            @Override
            public boolean notifyStartEntryPoint()
            {
                if (network.isNetworkEnabled())
                {
                    if(entryPoint.isEntryPointOff())
                    {
                        entryPoint.startInReady();
                        return  true;
                    }
                    if (entryPoint.isEntryPointReady())
                    {
                        return true;
                    }
                }
                else if (network.isNetworkAvailable())
                {
                    if(entryPoint.isEntryPointOff())
                    {
                        entryPoint.startInPause();
                        return true;
                    }
                }
                if (!entryPoint.isEntryPointOff())
                {
                    entryPoint.stop();
                }
                return false;
            }

            @Override
            public boolean notifyStopEntryPoint()
            {
                if (!entryPoint.isEntryPointOff())
                {
                    entryPoint.stop();
                }
                return true; // if not taken, the entry point should already have benn off
            }

            @Override
            public int notifyBluetoothChanged()
            {
                if (network.isNetworkEnabled())
                {
                    if(entryPoint.isEntryPointPaused())
                    {
                        entryPoint.restart();
                        return Constants.BLUETOOTH_CHANGED_ON;
                    }
                    else if (entryPoint.isEntryPointReady())
                    {
                        return Constants.DONE;
                    }
                }
                else if (network.isNetworkAvailable())
                {
                    if(entryPoint.isEntryPointReady())
                    {
                        entryPoint.pause();
                        return Constants.BLUETOOTH_CHANGED_OFF;
                    }
                    else if (entryPoint.isEntryPointPaused())
                    {
                        return Constants.DONE;
                    }
                }
                if (!entryPoint.isEntryPointOff())
                {
                    entryPoint.stop();
                }
                return Constants.ERROR;
            }
        };
    }

    @Override
    public AuthenticationServiceStatusModel getAuthenticationServiceStatusModel()
    {
        return new AuthenticationServiceStatusModel() {
            @Override
            public boolean isAuthenticationServiceActive() {
                return !entryPoint.isEntryPointOff();
            }
        };
    }

    @Override
    public SessionModel getSessionModel() {
        return new SessionModel() {
            @Override
            public void createNewSession(String applicationName, String login)
            {
                service.createSession(applicationName, login);
            }

            @Override
            public void pushSessionToSelectDevices(Session session)
            {
                service.pushNextSessionSelectDevices(session);
            }

            @Override
            public void pushSessionToWaitForSelectWeights(Session session)
            {
                service.pushNextSessionWaitingForSelectWeights(session);
            }

            @Override
            public void pushSessionToSelectWeights(Session session)
            {
                service.pushNextSessionSelectWeights(session);
            }

            @Override
            public void pushSessionToWaitForMain(Session session)
            {
                service.pushNextWaitForMain(session);
            }

            @Override
            public void pushSessionToMain(Session session)
            {

                service.pushNextSessionMain(session);
            }

            @Override
            public void clear()
            {
                service.clear();
            }

            @Override
            public ArrayList<Possibility> getInitialPossibilities() {
                ArrayList<Device> devices               =  network.getPairedDevices();
                ArrayList<Possibility> possibilities    = new ArrayList<>();
                for (Device device : devices)
                {
                    possibilities.add(new Possibility(device));
                }
                return possibilities;
            }


            @Override
            public int getNumberOfWaitingSessionSelectDevices() {
                return service.getNumberOfWaitingSessionSelectDevices();
            }

            @Override
            public int getNumberOfWaitingSessionSelectWeights() {
                return service.getNumberOfWaitingSessionSelectWeights();
            }

            @Override
            public int getNumberOfWaitingSessionSelectMain() {
                return service.getNumberOfWaitingSessionSelectMain();
            }

            @Override
            public Session getNextSessionSelectDevices() {
                return service.getNextSessionSelectDevices();
            }

            @Override
            public Session getNextSessionWaitingForSelectDevices() {
                return service.getNextSessionWaitingForSelectDevices();
            }

            @Override
            public Session getNextSessionSelectWeights() {
                return service.getNextSessionSelectWeights();
            }

            @Override
            public Session getNextSessionWaitingForSelectWeights() {
                return service.getNextSessionWaitingForSelectWeights();
            }

            @Override
            public Session getNextSessionMain() {
                return service.getNextSessionMain();
            }

            @Override
            public Session getNextSessionWaitingForMain() {
                return service.getNextSessionWaitingForMain();
            }


        };
    }


}
