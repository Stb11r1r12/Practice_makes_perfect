package com.example.demo.dto;

import com.example.demo.entities.Transactions;

import java.util.Date;

public class TransactionsDto {
    private long id;
    private long user_ID;
    private long category_ID;
    private int amount;
    private Date date;
    public TransactionsDto(Transactions transactions){
        this.id = transactions.getTransaction_ID();
        this.user_ID = transactions.getUser_ID().getUser_ID();
        this.category_ID = transactions.getCategories_ID().getCategory_ID();
        this.amount = transactions.getAmount();
        this.date = transactions.getDate();
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

    public long getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(long category_ID) {
        this.category_ID = category_ID;
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
