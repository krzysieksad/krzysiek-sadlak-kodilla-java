package com.kodilla.good.patterns.challenges.misc;

import java.util.ArrayDeque;
import java.util.Queue;

public class Orders {
    private Queue<Order> orders = new ArrayDeque<>();

    public boolean addOrder(final Order order) {
        return true;
    }

    public Order getOrder() {
        return null;
    }
}
