package com.example.demo.dto;

import com.example.demo.entities.Cards;
import com.example.demo.entities.User;

public class CardsDto {
    private long id;
    private long user_ID;
    private String bank_name;
    private int amount;
    public CardsDto(Cards cards) {
        this.id = cards.getCard_ID();
        this.user_ID = cards.getUser_ID().getUser_ID();
        this.bank_name = cards.getName();
        this.amount = cards.getAmount();
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

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
