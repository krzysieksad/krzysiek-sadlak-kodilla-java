package com.kodilla.good.patterns.challenges.misc;

public class User {
    private final String userName;
    private final String email;
    private final String phoneNumber;

    public User(final String userName, final String email, final String phoneNumber) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
