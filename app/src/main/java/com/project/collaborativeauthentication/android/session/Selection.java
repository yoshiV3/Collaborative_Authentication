package com.project.collaborativeauthentication.android.session;

public class Selection
{
    private final String name;
    private final int    weight;

    public Selection(String name, int weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}
