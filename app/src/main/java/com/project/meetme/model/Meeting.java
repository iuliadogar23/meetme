package com.project.meetme.model;

import java.io.Serializable;
import java.util.Calendar;

public class Meeting implements Serializable {
    private String id;
    private String title;
    private String description;
    private Long datetime;
    private String location;

    public String toStringDisplay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(datetime);
        return "Title: " + title + '\n' +
                "Description: " + description + '\n' +
                "Date and time: " + calendar.getTime() + '\n' +
                "Location: " + location + '\n';
    }

    @Override
    public String toString() {
        return title + " at " + location;
    }

    public Meeting() {
    }

    public Meeting(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Meeting(String title, String description, Long datetime, String location) {
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Long getDate() {
        return datetime;
    }

    public void setDate(Long datetime) {
        this.datetime = datetime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
