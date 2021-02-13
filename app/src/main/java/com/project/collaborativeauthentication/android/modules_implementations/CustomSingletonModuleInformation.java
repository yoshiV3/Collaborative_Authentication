package com.project.collaborativeauthentication.android.modules_implementations;

import com.project.collaborativeauthentication.android.modules_interfaces.ModuleInformation;

public class CustomSingletonModuleInformation implements ModuleInformation
{
    private static CustomSingletonModuleInformation instance = null;

    private CustomSingletonModuleInformation(){}

    public static CustomSingletonModuleInformation getInstance()
    {
        if(instance == null)
        {
            instance = new CustomSingletonModuleInformation();
        }
        return instance;
    }
}
