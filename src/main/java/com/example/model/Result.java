package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

/**
 * Created by Rudyard Moreno on 04/03/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 4 - JSON Endpoints
 * Model - Result Class
 */
public class Result {
    //Properties
    @JsonView(Views.DetailView.class)
    private int userId;
    @JsonView(Views.ListView.class)
    private String user;
    @JsonView(Views.DetailView.class)
    private String email;
    @JsonView(Views.ListView.class)
    private Date date;
    @JsonView(Views.ListView.class)
    private String statusText;

    //Getters

    public int getUserId() { return userId; }
    public String getUser() { return user; }
    public String getEmail() { return email; }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="America/Denver")
    public Date getDate() { return date; }
    public String getStatusText() { return statusText; }

    //Setters
    public void setUserId(int value) { userId=value; }
    public void setUser(String value) { user=value; }
    public void setEmail(String value) { email=value; }
    public void setDate(Date value) { date=value; }
    public void setStatusText(String value) { statusText=value; }

    //Constructor
    public Result() {
        setUserId(0);
        setUser("");
        setEmail("");
        setDate(new Date());
        setStatusText("");
    }
}
