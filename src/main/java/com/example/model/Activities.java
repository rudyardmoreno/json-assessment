package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudyard Moreno on 04/04/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 4 - JSON Endpoints
 * Model - Activities Class
 */
public class Activities {
    //Properties
    private List<Activity> activities;

    //Getters
    public List<Activity> getActivities() { return activities; }

    //Setters
    public void setActivities(List<Activity> value) { activities=value; }

    //Constructor
    public Activities() {
        setActivities(new ArrayList<Activity>());
    }
}
