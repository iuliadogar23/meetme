package com.project.meetme.model;

public class Participants {
    private Integer id;
    private Integer userId;
    private Integer meetingId;

    public Participants() {
    }

    public Participants(Integer userId, Integer meetingId) {
        this.userId = userId;
        this.meetingId = meetingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }
}
