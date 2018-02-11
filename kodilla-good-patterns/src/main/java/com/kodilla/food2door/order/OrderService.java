package com.kodilla.food2door.order;

import com.kodilla.food2door.producers.ExtraFoodShop;
import com.kodilla.food2door.producers.GlutenFreeShop;
import com.kodilla.food2door.producers.HealthyShop;
import com.kodilla.food2door.producers.Producer;
import com.kodilla.food2door.producers.ProducerId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderService {
    private final Map<ProducerId, Producer> producerMap = new HashMap<>();

    OrderService() {
        producerMap.put(ProducerId.EXTRA_FOOD_SHOP, new ExtraFoodShop());
        producerMap.put(ProducerId.GLUTEN_FREE_SHOP, new GlutenFreeShop());
        producerMap.put(ProducerId.HEALTHY_SHOP, new HealthyShop());
    }

    /**
     * Process order.
     * @param order order
     * @return summary
     */
    public OrderSummary processOrder(final Order order) {

        Set<ProducerId> producerIds = order.showOrderList().stream()
                .map(SingleOrder::getProducerId)
                .collect(Collectors.toSet());

        List<OrderSummary> orderSummaryList = new ArrayList<>();
        for (ProducerId producerId : producerIds) {
            Order singleShopOrder = new Order();
            order.showOrderList().stream()
                    .filter(singleOrder -> singleOrder.getProducerId().equals(producerId))
                    .forEach(singleShopOrder::addToList);
            orderSummaryList.add(producerMap.get(producerId).process(singleShopOrder));
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