package com.kodilla.good.patterns.challenges.service;

import com.kodilla.good.patterns.challenges.misc.OrderRequest;

public interface OrderService {
    boolean order(final OrderRequest orderRequest);
}
