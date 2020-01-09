package com.project.meetme.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Meeting {
    private Integer id;
    private String title;
    private String description;
    private Timestamp date;
    private String location; // Location type?

    public Meeting(JSONObject object) {
        try {
            this.title = object.getString("title");
            this.description = object.getString("description");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Meeting() {
    }

    public Meeting(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Meeting(String title, String description, Timestamp date, String location) {
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

    public static ArrayList<Meeting> fromJson(JSONArray jsonObjects) {
        ArrayList<Meeting> meetings = new ArrayList<Meeting>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                meetings.add(new Meeting(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return meetings;
    }
}
