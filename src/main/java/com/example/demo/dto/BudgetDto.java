package com.example.demo.dto;

import com.example.demo.entities.Budget;

public class BudgetDto {
    private long id;
    private long userId;
    private long categoryId;
    private int amount;
    public BudgetDto(Budget budget) {
        this.id = budget.getbudgetId();
        this.userId = budget.getUserId().getuserId();
        this.categoryId = budget.getCategoriesId().getcategoryId();
        this.amount = budget.getAmount();
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
