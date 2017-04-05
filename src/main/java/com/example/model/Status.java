package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by Rudyard Moreno on 04/04/2017
 * DISH NETWORK - Galvanize Training
 * CNE-002 (Dish)
 * Unit 4 - JSON Endpoints
 * Model - Status Class
 */
public class Status {
    //Properties
    private String text;
    private Date date;

    //Getters
    public String getText() { return  text; }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="America/Denver")
    public Date getDate() { return date; }

    //Setters
    public void setText(String value) { text=value;}
    public void setDate(Date value) {date=value;}

    //Constructor
    public Status() {
        setText("");
        setDate(new Date());
    }
}
