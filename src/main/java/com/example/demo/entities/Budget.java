package com.example.demo.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="budget_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User userId;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Categories categoriesId;
    @Column(name="amount")
    private int amount;

    public Long getbudgetId() {
        return id;
    }
    public void setUserId(User userId) {
        this.userId = userId;
    }
    public User getUserId() {
        return userId;
    }
    public Categories getCategoriesId() {
        return categoriesId;
    }
    public int getAmount() {
        return amount;
    }
}
