package com.kodilla.food2door.order;

import com.kodilla.food2door.producers.Producer;
import com.kodilla.food2door.producers.ProducerId;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrderService {
    private final Map<ProducerId, Producer> producerMap;

    OrderService(final Map<ProducerId, Producer> producerMap) {
        this.producerMap = producerMap;
    }

    /**
     * Process order.
     *
     * @param order order
     * @return summary
     */
    public OrderSummary processOrder(final Order order) {
        Map<ProducerId, List<SingleOrder>> orderMap = order.showOrderList().stream().collect(Collectors.groupingBy(SingleOrder::getProducerId));

        List<OrderSummary> orderSummaryList = new ArrayList<>();

        for (Map.Entry<ProducerId, List<SingleOrder>> entry : orderMap.entrySet()) {
            orderSummaryList.add(producerMap.get(entry.getKey()).process(new Order(entry.getValue())));
        }

        return concatenateSummaries(orderSummaryList);
    }

    private OrderSummary concatenateSummaries(final List<OrderSummary> summaryList) {
        List<String> bought = new ArrayList<>();
        List<String> unavailable = new ArrayList<>();
        double price = 0;

        for (OrderSummary orderSummary : summaryList) {
            bought.addAll(orderSummary.getBoughtList());
            unavailable.addAll(orderSummary.getProductsUnavailable());
            price += orderSummary.getPaymentAmount();
        }
        bought.sort(String::compareTo);
        unavailable.sort(String::compareTo);

        return new OrderSummary(price, bought, unavailable);
    }
}