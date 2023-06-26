package com.example.demo.dto;

import com.example.demo.entities.Categories;

public class CategoriesDto {
    private long id;
    private String name;
    private boolean type;
    public CategoriesDto(Categories categories){
        this.id = categories.getCategory_ID();
        this.name = categories.getName();
        this.type = categories.getType();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
