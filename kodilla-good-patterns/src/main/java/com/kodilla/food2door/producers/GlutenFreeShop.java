package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;
import com.kodilla.food2door.order.SingleOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GlutenFreeShop implements Producer {
    private Map<String, Double> products = new HashMap<>();

    /**
     * Shop offer.
     */
    public GlutenFreeShop() {
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

    /**
     * Processing order of food.
     * @param order order
     * @return summary
     */
    public OrderSummary process(final Order order) {
        List<SingleOrder> toBuyList = order.showOrderList().stream()
                .filter(singleOrder -> products.containsKey(singleOrder.getProduct()))
                .collect(Collectors.toList());

        double payment = toBuyList.stream()
                .mapToDouble(singleOrder -> singleOrder.getAmount() * products.get(singleOrder.getProduct()))
                .sum();

        List<String> productsAvailable = toBuyList.stream()
                .map(SingleOrder::getProduct)
                .collect(Collectors.toList());

        List<String> productUnavailable = order.showOrderList().stream()
                .filter(singleOrder -> !products.containsKey(singleOrder.getProduct()))
                .map(SingleOrder::getProduct)
                .collect(Collectors.toList());

        return new OrderSummary(payment, productsAvailable, productUnavailable);
    }
}
