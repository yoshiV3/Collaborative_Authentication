package com.project.collaborativeauthentication.android.modules_implementations.authentication_service;

public class Possibility
{
    private static  int currentNextIdentifier = 0;


    public static void startNewBatch()
    {
        currentNextIdentifier = 0;
    }

    public static int getNextIdentifier()
    {
        int newIdentifier     = currentNextIdentifier;
        currentNextIdentifier = currentNextIdentifier +1;
        return   newIdentifier;
    }

    private final String name;
    private final int    identifier;
    private int          weight = 1;


    public Possibility(String name)
    {
        this.name        = name;
        this.identifier  = getNextIdentifier();
    }

    public String getName() {
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
