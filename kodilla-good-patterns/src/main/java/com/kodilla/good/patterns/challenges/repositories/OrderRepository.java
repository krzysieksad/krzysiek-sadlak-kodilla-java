package com.kodilla.good.patterns.challenges.repositories;

import com.kodilla.good.patterns.challenges.items.Item;
import com.kodilla.good.patterns.challenges.misc.User;

public interface OrderRepository {
    void createOrder(final User user, final Item item);
}
