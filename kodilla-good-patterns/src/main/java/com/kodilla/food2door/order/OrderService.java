package com.kodilla.food2door.order;

import com.kodilla.food2door.producers.Producer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderService {
    /**
     * Process order.
     * @param order order
     * @return summary
     */
    public OrderSummary processOrder(final Order order) {

        Set<Producer> producers = order.showOrderList().stream()
                .map(SingleOrder::getProducer)
                .collect(Collectors.toSet());

        List<OrderSummary> orderSummaryList = new ArrayList<>();
        for (Producer producer : producers) {
            Order singleShopOrder = new Order();
            order.showOrderList().stream()
                    .filter(singleOrder -> singleOrder.getProducer().equals(producer))
                    .forEach(singleShopOrder::addToList);
            orderSummaryList.add(producer.process(singleShopOrder));
        }

        return concatenateSummaries(orderSummaryList);
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