package com.example.demo.dto;

import com.example.demo.entities.Cards;

public class CardsDto {
    private long id;
    private long userId;
    private String bankName;
    private int amount;
    public CardsDto(Cards cards) {
        this.id = cards.getCard_ID();
        this.userId = cards.getUserId().getUser_ID();
        this.bankName = cards.getName();
        this.amount = cards.getAmount();
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

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
