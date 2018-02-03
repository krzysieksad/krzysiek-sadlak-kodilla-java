package com.kodilla.good.patterns.challenges.items;

public class Phone implements Item {
    private final String phone;

    public Phone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
