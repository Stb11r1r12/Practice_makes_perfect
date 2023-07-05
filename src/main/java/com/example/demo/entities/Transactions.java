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
    private User userId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_ID", nullable = false)
    //@Column(name="category_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categories categoriesId;

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
    public void setUserId(User user_ID) {
        this.userId = user_ID;
    }
    public User getUserId() {
        return userId;
    }
    public void setCategoriesId(Categories categories_ID) {
        this.categoriesId = categories_ID;
    }
    public Categories getCategoriesId() {
        return categoriesId;
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
