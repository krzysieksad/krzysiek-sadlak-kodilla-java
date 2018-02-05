package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;
import com.kodilla.food2door.order.SingleOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExtraFoodShop implements Producer {
    private Map<String, Double> products = new HashMap<>();

    /**
     * Shop offer.
     */
    public ExtraFoodShop() {
        products.put("Apple", 3.49);
        products.put("Banana", 5.49);
        products.put("Orange", 4.90);
        products.put("Pineapple", 11.90);
        products.put("Watermelon", 1.90);
        products.put("Hazelnut", 7.50);
        products.put("Lemon", 2.99);
        products.put("Kiwi", 6.45);
        products.put("Mango", 8.50);
        products.put("Grapes", 7.49);
    }

    /**
     * Processing order of food.
     * @param order order
     * @return summary
     */
    public OrderSummary process(final Order order) {
        List<String> toBuyList = order.showOrderList().stream()
                .filter(singleOrder -> products.containsKey(singleOrder.getProduct()))
                .map(SingleOrder::getProduct)
                .collect(Collectors.toList());

        List<String> productUnavailable = order.showOrderList().stream()
                .filter(singleOrder -> !products.containsKey(singleOrder.getProduct()))
                .map(SingleOrder::getProduct)
                .collect(Collectors.toList());

        double payment = order.showOrderList().stream()
                .filter(singleOrder -> products.containsKey(singleOrder.getProduct()))
                .mapToDouble(singleOrder -> singleOrder.getAmount() * products.get(singleOrder.getProduct()))
                .sum();

        return new OrderSummary(payment, toBuyList, productUnavailable);
    }
}
