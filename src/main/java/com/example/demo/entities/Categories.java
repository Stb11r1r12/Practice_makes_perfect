package com.example.demo.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_ID")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private boolean type;

    public Long getcategoryId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setType(boolean type) {
        this.type = type;
    }
    public boolean getType() {
        return type;
    }
}
