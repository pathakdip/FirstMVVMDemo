package com.example.firstmvvmdemo.model;

public class User {
    private String email;
    private String password;
    private String name;
    private String contact;


    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email,String contact) {
        this.email = email;
        this.name = name;
        this.contact=contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

}
