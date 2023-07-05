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
    private Categories categories_ID;
    @Column(name="amount")
    private int amount;
    public Budget(){}
    public void setBudget_ID(Long budgetId) {
        this.id = budgetId;
    }
    public Long getBudget_ID() {
        return id;
    }
    public void setUserId(User user_ID) {
        this.userId = user_ID;
    }
    public User getUserId() {
        return userId;
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
}
