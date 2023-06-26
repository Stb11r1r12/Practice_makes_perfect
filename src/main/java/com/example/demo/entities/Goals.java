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
    private int target_amount;
    @Column(name="current_amount")
    private int current_amount;

    public Goals(){}
    public void setGoal_ID(Long goalId) {
        this.id = goalId;
    }
    public Long getGoal_ID() {
        return id;
    }
    public void setUser_ID(User user_ID) {
        this.user_ID = user_ID;
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
    public void setTarget_amount(int target_amount) {
        this.target_amount = target_amount;
    }
    public int getTarget_amount() {
        return target_amount;
    }
    public void setCurrent_amount(int current_amount) {
        this.current_amount = current_amount;
    }
    public int getCurrent_amount() {
        return current_amount;
    }
}
