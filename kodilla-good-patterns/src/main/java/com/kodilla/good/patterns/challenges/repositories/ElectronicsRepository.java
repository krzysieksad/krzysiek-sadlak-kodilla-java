package com.kodilla.good.patterns.challenges.repositories;

import com.kodilla.good.patterns.challenges.misc.OrderRequest;

public class ElectronicsRepository implements OrderRepository {
    public void createOrder(final OrderRequest orderRequest) {
        System.out.println("Order added to Electronics orders.");
    }
}
