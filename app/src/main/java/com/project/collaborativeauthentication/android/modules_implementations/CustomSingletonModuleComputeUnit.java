package com.project.collaborativeauthentication.android.modules_implementations;

import com.project.collaborativeauthentication.android.modules_interfaces.ModuleComputeUnit;

public class CustomSingletonModuleComputeUnit implements ModuleComputeUnit
{
    private static CustomSingletonModuleComputeUnit instance = null;

    private CustomSingletonModuleComputeUnit(){}

    public static CustomSingletonModuleComputeUnit getInstance()
    {
        if(instance == null)
        {
            instance = new CustomSingletonModuleComputeUnit();
        }
        return instance;
    }
}
