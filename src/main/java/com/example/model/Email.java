package com.example.model;

/**
 * Created by Rudyard Moreno on 04/04/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 4 - JSON Endpoints
 * Model - Email Class
 */
public class Email {
    //Properties
    private int id;
    private String address;
    private boolean primary;

    //Getters
    //public int getId() { return id; }
    public String getAddress() { return  address; }
    public boolean isPrimary() { return primary; }

    //Setters
    public void setId(int value) { id=value; }
    public void setAddress(String value) { address=value;}
    public void setPrimary(boolean value) {primary=value;}

    //Constructor
    public Email() {
        setId(0);
        setAddress("");
        setPrimary(false);
    }
}
