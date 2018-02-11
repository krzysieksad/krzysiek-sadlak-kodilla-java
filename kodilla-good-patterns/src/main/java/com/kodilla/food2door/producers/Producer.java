package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;

public interface Producer {
    OrderSummary process(final Order order);
    ProducerId getProducerId();
}
