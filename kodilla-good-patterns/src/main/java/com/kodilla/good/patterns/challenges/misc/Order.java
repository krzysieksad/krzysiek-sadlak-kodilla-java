package com.kodilla.good.patterns.challenges.misc;

import com.kodilla.good.patterns.challenges.items.Item;

public class Order {
    private final User user;
    private final Item item;

    public Order(final User user, final Item item) {
        this.user = user;
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public Item getItem() {
        return item;
    }
}
