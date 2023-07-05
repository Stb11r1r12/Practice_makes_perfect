package com.example.demo.dto;

import com.example.demo.entities.Transactions;

import java.util.Date;

public class TransactionsDto {
    private long id;
    private long userId;
    private long categoryId;
    private int amount;
    private Date date;
    public TransactionsDto(Transactions transactions){
        this.id = transactions.gettransactionId();
        this.userId = transactions.getUserId().getuserId();
        this.categoryId = transactions.getCategoriesId().getcategoryId();
        this.amount = transactions.getAmount();
        this.date = transactions.getDate();
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
