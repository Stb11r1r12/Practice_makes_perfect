package com.example.demo.dto;

import com.example.demo.entities.Budget;

public class BudgetDto {
    private long id;
    private long user_id;
    private long category_id;
    private int amount;
    public BudgetDto(Budget budget) {
        this.id = budget.getBudget_ID();
        this.user_id = budget.getUser_ID().getUser_ID();
        this.category_id = budget.getCategories_ID().getCategory_ID();
        this.amount = budget.getAmount();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
