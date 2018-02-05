package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;
import com.kodilla.food2door.order.SingleOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HealthyShop implements Producer {
    private Map<String, Double> products = new HashMap<>();

    /**
     * Shop offer.
     */
    public HealthyShop() {
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

    /**
     * Processing order of food.
     * @param order order
     * @return summary
     */
    public OrderSummary process(final Order order) {
        List<String> bought = new ArrayList<>();
        List<String> unavailable = new ArrayList<>();
        double price = 0;

        for (SingleOrder singleOrder : order.showOrderList()) {
            if (products.containsKey(singleOrder.getProduct())) {
                bought.add(singleOrder.getProduct());
                price += singleOrder.getAmount() * products.get(singleOrder.getProduct());
            } else {
                unavailable.add(singleOrder.getProduct());
            }
        }
        return new OrderSummary(price, bought, unavailable);
    }
}
