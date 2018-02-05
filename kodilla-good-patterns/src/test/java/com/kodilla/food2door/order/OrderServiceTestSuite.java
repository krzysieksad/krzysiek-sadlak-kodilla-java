package com.kodilla.food2door.order;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OrderServiceTestSuite {
    private Order prepareOrder() {
        Order order = new Order();
        order.addToList(new SingleOrder("ExtraFoodShop", "Apple", 4));
        order.addToList(new SingleOrder("ExtraFoodShop", "Pineapple", 2));
        order.addToList(new SingleOrder("ExtraFoodShop", "Watermelon", 8));
        order.addToList(new SingleOrder("ExtraFoodShop", "Eggs", 20));
        order.addToList(new SingleOrder("ExtraFoodShop", "Lemon", 5));
        order.addToList(new SingleOrder("GlutenFreeShop", "Lamb", 2));
        order.addToList(new SingleOrder("GlutenFreeShop", "Grain Cookies", 4));
        order.addToList(new SingleOrder("GlutenFreeShop", "Veal", 3));
        order.addToList(new SingleOrder("GlutenFreeShop", "Fish", 10));
        order.addToList(new SingleOrder("GlutenFreeShop", "Shrimp", 3));
        order.addToList(new SingleOrder("HealthyShop", "Tomato", 20));
        order.addToList(new SingleOrder("HealthyShop", "Hot Pepper", 15));
        order.addToList(new SingleOrder("HealthyShop", "Spinach", 10));
        order.addToList(new SingleOrder("HealthyShop", "Brussels", 9));
        order.addToList(new SingleOrder("HealthyShop", "Lemon", 30));
        return order;
    }

    @Test
    public void testProcess() {
        //given
        Order order = prepareOrder();
        OrderService orderService = new OrderService();

        //when
        OrderSummary orderSummary = orderService.processOrder(order);

        //then
        Assert.assertEquals(960.72, orderSummary.getPaymentAmount(), 0);
        Assert.assertEquals(Arrays.asList("Apple", "Pineapple", "Watermelon", "Lemon", "Lamb", "Grain Cookies", "Fish", "Tomato", "Hot Pepper", "Spinach",
                "Brussels"), orderSummary.getBoughtList());
        Assert.assertEquals(Arrays.asList("Eggs", "Veal", "Shrimp", "Lemon"), orderSummary.getProductsUnavailable());
    }
}
