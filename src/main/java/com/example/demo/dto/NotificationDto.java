package com.example.demo.dto;

import com.example.demo.entities.Notifications;

import java.util.Date;

public class NotificationDto {
    private long id;
    private long userId;
    private String message;
    private Date date;
    public NotificationDto(Notifications notification) {
        this.id = notification.getnotificationId();
        this.userId = notification.getUserId().getuserId();
        this.message = notification.getName();
        this.date = notification.getDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
