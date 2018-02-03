package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.misc.Order;
import com.kodilla.good.patterns.challenges.misc.OrderDto;
import com.kodilla.good.patterns.challenges.repositories.OrderRepository;
import com.kodilla.good.patterns.challenges.information.OrderInformation;
import com.kodilla.good.patterns.challenges.service.OrderService;

public class ProductOrderService {
    private final OrderInformation orderInformation;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    /**
     * Order service in store.
     * @param orderInformation interface for sending information about order
     * @param orderService interface for creating order
     * @param orderRepository interface for saving order
     */
    public ProductOrderService(final OrderInformation orderInformation, final OrderService orderService, final OrderRepository orderRepository) {
        this.orderInformation = orderInformation;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final Order order) {
        return null;
    }
}
