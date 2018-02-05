package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.misc.OrderRequest;

public class JacketOrder implements OrderService {
    public boolean order(final OrderRequest orderRequest) {
        System.out.println("Jacket ordered for " + orderRequest.getUser().getUserName() + ": " + orderRequest.getItem().toString());
        return true;
    }
}
