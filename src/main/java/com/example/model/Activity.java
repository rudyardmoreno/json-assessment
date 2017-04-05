package com.example.model;

/**
 * Created by Rudyard Moreno on 04/04/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 4 - JSON Endpoints
 * Model - Activity Class
 */
public class Activity {
    //Properties
    private User user;
    private Status status;

    //Getters
    public User getUser() { return user; }
    public Status getStatus() { return status; }

    //Setters
    public void setUser(User value) { user=value; }
    public void setStatus(Status value) { status=value; }

    //Constructor
    public Activity() {
        setUser(new User());
        setStatus(new Status());
    }
}
