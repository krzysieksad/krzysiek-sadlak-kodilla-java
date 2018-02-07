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
            unavailable.addAll(orderSummary.getProductsUnavailable());
            price += orderSummary.getPaymentAmount();
        }

        return new OrderSummary(price, bought, unavailable);
    }
}
/*
public class OrderService {
    private final Order extraFoodShopOrder = new Order();
    private final Order glutenFreeShopOrder = new Order();
    private final Order healthyShopOrder = new Order();

    /**
     * Process order.
     * @param order order
     * @return summary
     */
    /*public OrderSummary processOrder(final Order order) {
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        HealthyShop healthyShop = new HealthyShop();

        divideOrder(order);

        OrderSummary extraFoodShopOrderSummary = extraFoodShop.process(extraFoodShopOrder);
        OrderSummary glutenFreeShopOrderSummary = glutenFreeShop.process(glutenFreeShopOrder);
        OrderSummary healthyShopOrderSummary = healthyShop.process(healthyShopOrder);

        return concatenateSummaries(Arrays.asList(extraFoodShopOrderSummary, glutenFreeShopOrderSummary, healthyShopOrderSummary));
    }

    private void divideOrder(final Order order) {
        for (SingleOrder singleOrder : order.showOrderList()) {
            switch (singleOrder.getProducer()) {
                case "ExtraFoodShop":
                    extraFoodShopOrder.addToList(singleOrder);
                    break;
                case "GlutenFreeShop":
                    glutenFreeShopOrder.addToList(singleOrder);
                    break;
                case "HealthyShop":
                    healthyShopOrder.addToList(singleOrder);
                    break;
                default:
                    System.out.println("Wrong shop name.");
                    break;
            }
        }
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

        return new OrderSummary(price, bought, unavailable);
    }
}*/
