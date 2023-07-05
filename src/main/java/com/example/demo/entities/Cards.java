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
    public Long getcardId() {
        return id;
    }
    public User getUserId() {
        return userId;
    }
    public void setName(String bankName) {
        this.bankName = bankName;
    }
    public String getName() {
        return bankName;
    }
    public int getAmount() {
        return amount;
    }
}
