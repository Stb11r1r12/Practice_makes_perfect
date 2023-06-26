package com.example.demo.dto;

import com.example.demo.entities.Goals;

public class GoalsDto {
    private long id;
    private long user_ID;
    private String name;
    private int target_amount;
    private int current_amount;
    public GoalsDto(Goals goal){
        this.id = goal.getGoal_ID();
        this.user_ID = goal.getUser_ID().getUser_ID();
        this.name = goal.getName();
        this.target_amount = goal.getTarget_amount();
        this.current_amount = goal.getCurrent_amount();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTarget_amount() {
        return target_amount;
    }

    public void setTarget_amount(int target_amount) {
        this.target_amount = target_amount;
    }

    public int getCurrent_amount() {
        return current_amount;
    }

    public void setCurrent_amount(int current_amount) {
        this.current_amount = current_amount;
    }
}
