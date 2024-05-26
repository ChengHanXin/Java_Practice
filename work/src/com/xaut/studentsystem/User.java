package com.xaut.studentsystem;

public class User {
    private String name;
    private String password;
    private String id;
    private String phoneNumber;

    public User() {
    }

    public User(String name, String password, String id, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
