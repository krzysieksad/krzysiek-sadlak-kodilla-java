package com.kodilla.food2door.order;

import com.kodilla.food2door.producers.Producer;
import com.kodilla.food2door.producers.ProducerId;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class OrderService {
    private final Map<ProducerId, Producer> producerMap;

    public OrderService(final Map<ProducerId, Producer> producerMap) {
        this.producerMap = producerMap;
    }

    /**
     * Process order.
     *
     * @param order order
     * @return summary
     */
    public OrderSummary processOrder(final Order order) {
        Map<ProducerId, Order> orderMap = new HashMap<>();
        order.showOrderList().forEach(singleOrder -> addSingleOrderToMap(orderMap, singleOrder.getProducerId(), singleOrder));

        List<OrderSummary> orderSummaryList = new ArrayList<>();

        for (Map.Entry<ProducerId, Order> entry : orderMap.entrySet()) {
            orderSummaryList.add(producerMap.get(entry.getKey()).process(entry.getValue()));
        }

        return concatenateSummaries(orderSummaryList);
    }

    private void addSingleOrderToMap(final Map<ProducerId, Order> orderMap, final ProducerId key, final SingleOrder value) {
        if (orderMap.containsKey(key)) {
            orderMap.get(key).addToList(value);
        } else {
            orderMap.put(key, new Order());
            orderMap.get(key).addToList(value);
        }
    }

    private OrderSummary concatenateSummaries(final List<OrderSummary> summaryList) {
        List<String> bought = new ArrayList<>();
        List<String> unavailable = new ArrayList<>();
        double price = 0;

        for (OrderSummary orderSummary : summaryList) {
            bought.addAll(orderSummary.getBoughtList());
            bought.sort(String::compareTo);
            unavailable.addAll(orderSummary.getProductsUnavailable());
            unavailable.sort(String::compareTo);
            price += orderSummary.getPaymentAmount();
        }

        return new OrderSummary(price, bought, unavailable);
    }
}