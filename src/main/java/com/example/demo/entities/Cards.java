package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "cards")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userId;
    @Column(name="bank_name")
    private String bankName;
    @Column(name="amount")
    private int amount;
    public void setCard_ID(Long cardId) {
        this.id = cardId;
    }
    public Long getCard_ID() {
        return id;
    }
    public void setUserId(User user_ID) {
        this.userId = user_ID;
    }
    public User getUserId() {
        return userId;
    }
    public void setName(String bank_name) {
        this.bankName = bank_name;
    }
    public String getName() {
        return bankName;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
