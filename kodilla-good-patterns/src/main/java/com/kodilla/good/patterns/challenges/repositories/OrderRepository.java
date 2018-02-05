package com.kodilla.good.patterns.challenges.repositories;

import com.kodilla.good.patterns.challenges.misc.OrderRequest;

public interface OrderRepository {
    void createOrder(final OrderRequest orderRequest);
}
