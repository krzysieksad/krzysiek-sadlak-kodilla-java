package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.misc.OrderRequest;

public class TShirtOrder implements OrderService {
    public boolean order(final OrderRequest orderRequest) {
        System.out.println("T-Shirt ordered for " + orderRequest.getUser().getUserName() + ": " + orderRequest.getItem().toString());
        return true;
    }
}
