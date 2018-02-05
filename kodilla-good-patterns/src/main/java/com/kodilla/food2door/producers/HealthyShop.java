package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;

import java.util.HashMap;
import java.util.Map;

public class HealthyShop implements Producer {
    private Map<String, Double> products = new HashMap<>();

    /**
     * Shop offer.
     */
    HealthyShop() {
        this.products.put("Tomato", 3.50);
        this.products.put("Cucumber", 3.90);
        this.products.put("Sweet Pepper", 5.90);
        this.products.put("Hot Pepper", 8.49);
        this.products.put("Celery", 5.10);
        this.products.put("Lettuce", 4.00);
        this.products.put("Broccoli", 6.50);
        this.products.put("Spinach", 10.90);
        this.products.put("Cabbage", 3.99);
        this.products.put("Brussels", 5.50);
    }

    public OrderSummary process(final Order order) {
        return null;
    }
}
