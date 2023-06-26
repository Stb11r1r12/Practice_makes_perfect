package com.example.demo.dto;

import com.example.demo.entities.User;

public class UserDto {
    private long id;
    private String username;
    private String email;
    private String password;

    public UserDto(User user) {
        this.id = user.getUser_ID();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
