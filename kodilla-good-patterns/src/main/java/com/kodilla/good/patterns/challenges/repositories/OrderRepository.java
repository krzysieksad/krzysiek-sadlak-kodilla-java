package com.kodilla.good.patterns.challenges.repositories;

import com.kodilla.good.patterns.challenges.misc.Order;

public interface OrderRepository {
    void createOrder(final Order order);
}
