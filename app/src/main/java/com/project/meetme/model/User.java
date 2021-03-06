package com.project.meetme.model;

public class User {
    private String id;
    private String name;
    private String email;
    private String password;
    private Long phone;

    public User() {
    }

    @Override
    public String toString() {
        return "About your account: \n" +
                "Name: " + name + '\n' +
                "Email: " + email + '\n' +
                "Password: " + password + '\n' +
                "Phone: " + phone ;
    }

    public User(String name, String email, String password, Long phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
