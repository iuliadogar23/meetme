package com.project.meetme.model;

import java.sql.Timestamp;

public class Meeting {
    private Integer id;
    private String title;
    private String description;
    private Timestamp datetime;
    private String location;

    public Meeting() {
    }

    public Meeting(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Meeting(String title, String description, Timestamp datetime, String location) {
        this.title = title;
        this.description = description;
        this.datetime = datetime;
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
        return datetime;
    }

    public void setDate(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
