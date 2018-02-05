package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;

import java.util.HashMap;
import java.util.Map;

public class ExtraFoodShop implements Producer {
    private Map<String, Double> products = new HashMap<>();

    /**
     * Shop offer.
     */
    ExtraFoodShop() {
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

    public OrderSummary process(final Order order) {
        return null;
    }
}
