package com.project.meetme.model;

import java.sql.Timestamp;

public class Meetings {
    private Integer id;
    private String title;
    private String description;
    private Timestamp date;
    private String location; // Location type?

    public Meetings() {
    }

    public Meetings(String title, String description, Timestamp date, String location) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
