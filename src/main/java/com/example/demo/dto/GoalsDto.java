package com.example.demo.dto;

import com.example.demo.entities.Goals;

public class GoalsDto {
    private long id;
    private long userId;
    private String name;
    private int targetAmount;
    private int currentAmount;
    public GoalsDto(Goals goal){
        this.id = goal.getGoal_ID();
        this.userId = goal.getUser_ID().getUser_ID();
        this.name = goal.getName();
        this.targetAmount = goal.getTargetAmount();
        this.currentAmount = goal.getCurrentAmount();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(int targetAmount) {
        this.targetAmount = targetAmount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }
}
