package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "goals")
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="goal_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user_ID;
    @Column(name="name")
    private String name;
    @Column(name="target_amount")
    private int targetAmount;
    @Column(name="current_amount")
    private int currentAmount;

    public Goals(){}

    public Long getGoal_ID() {
        return id;
    }

    public User getUser_ID() {
        return user_ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getTargetAmount() {
        return targetAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }
}
