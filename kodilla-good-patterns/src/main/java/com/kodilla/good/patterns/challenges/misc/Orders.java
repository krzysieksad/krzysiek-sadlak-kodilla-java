package com.kodilla.good.patterns.challenges.misc;

import java.util.ArrayDeque;
import java.util.Queue;

public class Orders {
    private Queue<OrderRequest> orderRequests = new ArrayDeque<>();

    public boolean addOrder(final OrderRequest orderRequest) {
        return orderRequests.offer(orderRequest);
    }

    public OrderRequest getNextOrder() {
        return orderRequests.poll();
    }
}
