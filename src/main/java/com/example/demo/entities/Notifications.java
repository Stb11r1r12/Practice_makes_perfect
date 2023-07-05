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
    private User userId;
    @Column(name="message")
    private String message;
    @Column(name="date")
    private Date date;

    public Long getnotificationId() {
        return id;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }
    public User getUserId() {
        return userId;
    }
    public void setName(String message) {
        this.message = message;
    }
    public String getName() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
