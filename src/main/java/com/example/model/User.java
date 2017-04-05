package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rudyard Moreno on 04/04/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 4 - JSON Endpoints
 * Model - User Class
 */
public class User {
    //Properties
    private int id;
    private String username;
    private List<Email> emails;

    //Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public List<Email> getEmails() { return emails; }

    //Setters
    public void setId(int value) { id=value; }
    public void setUsername(String value) { username=value; }
    public void setEmails(List<Email> value) { emails=value; }

    //Methods
    public Email getPrimaryEmail() {
        Email primaryEmail = new Email();
        for (Email email : getEmails()) {
            if (email.isPrimary()) primaryEmail=email;
        }
        return primaryEmail;
    }

    //Constructor
    public User() {
        setId(0);
        setUsername("");
        setEmails(new ArrayList<Email>());
    }
}
