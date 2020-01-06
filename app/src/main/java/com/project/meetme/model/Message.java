package com.project.meetme.model;

public class Message {

    private Integer id;
    private String message;
    private boolean deleted;
    private boolean sent;
    private Integer userId;
    private Integer meetingId;

    public Message() {
    }

    public Message(String message, boolean deleted, boolean sent, Integer userId, Integer meetingId) {
        this.message = message;
        this.deleted = deleted;
        this.sent = sent;
        this.userId = userId;
        this.meetingId = meetingId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
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
