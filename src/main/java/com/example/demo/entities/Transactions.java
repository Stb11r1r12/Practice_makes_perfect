package com.example.demo.entities;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="transaction_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user_ID;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_ID", nullable = false)
    //@Column(name="category_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categories categories_ID;

    @Column(name="amount")
    private int amount;
    @Column(name="date")
    private Date date;
    public Transactions() {

    }
    public void setTransaction_ID(Long transactionId) {
        this.id = transactionId;
    }
    public Long getTransaction_ID() {
        return id;
    }
    public void setUser_ID(User user_ID) {
        this.user_ID = user_ID;
    }
    public User getUser_ID() {
        return user_ID;
    }
    public void setCategories_ID(Categories categories_ID) {
        this.categories_ID = categories_ID;
    }
    public Categories getCategories_ID() {
        return categories_ID;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
}
