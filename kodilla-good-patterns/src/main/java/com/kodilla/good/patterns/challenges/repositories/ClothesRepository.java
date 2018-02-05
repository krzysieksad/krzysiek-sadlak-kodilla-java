package com.kodilla.good.patterns.challenges.repositories;

import com.kodilla.good.patterns.challenges.misc.OrderRequest;

public class ClothesRepository implements OrderRepository {
    public void createOrder(final OrderRequest orderRequest) {
        System.out.println("Order added to Clothes orders.");
    }
}
