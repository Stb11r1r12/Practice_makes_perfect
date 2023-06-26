package com.example.demo.dto;

import com.example.demo.entities.Notifications;

import java.util.Date;

public class NotificationDto {
    private long id;
    private long user_ID;
    private String message;
    private Date date;
    public NotificationDto(Notifications notification) {
        this.id = notification.getNotification_ID();
        this.user_ID = notification.getUser_ID().getUser_ID();
        this.message = notification.getName();
        this.date = notification.getDate();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
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
