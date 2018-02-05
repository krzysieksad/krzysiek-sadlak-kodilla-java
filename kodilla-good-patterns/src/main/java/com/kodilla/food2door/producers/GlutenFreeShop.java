package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;

import java.util.HashMap;
import java.util.Map;

public class GlutenFreeShop implements Producer {
    private Map<String, Double> products = new HashMap<>();

    /**
     * Shop offer.
     */
    GlutenFreeShop() {
        this.products.put("Corn Bread", 7.50);
        this.products.put("Lamb", 45.00);
        this.products.put("Beef", 64.90);
        this.products.put("Pork", 34.50);
        this.products.put("Butter", 8.50);
        this.products.put("Grain Cookies", 36.99);
        this.products.put("Spring Salad", 13.90);
        this.products.put("Yogurt", 5.49);
        this.products.put("Sausage", 27.50);
        this.products.put("Fish", 29.90);
    }

    public OrderSummary process(final Order order) {
        return null;
    }
}
