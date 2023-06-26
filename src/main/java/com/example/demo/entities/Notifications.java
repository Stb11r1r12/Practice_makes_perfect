package com.example.demo.entities;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "notifications")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notification_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user_ID;
    @Column(name="message")
    private String message;
    @Column(name="date")
    private Date date;
    public Notifications(){}
    public void setNotification_ID(Long notificationId) {
        this.id = notificationId;
    }
    public Long getNotification_ID() {
        return id;
    }
    public void setUser_ID(User user_ID) {
        this.user_ID = user_ID;
    }
    public User getUser_ID() {
        return user_ID;
    }
    public void setName(String message) {
        this.message = message;
    }
    public String getName() {
        return message;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }
}
