package com.kodilla.food2door.order;

import com.kodilla.food2door.producers.ExtraFoodShop;
import com.kodilla.food2door.producers.GlutenFreeShop;
import com.kodilla.food2door.producers.HealthyShop;
import com.kodilla.food2door.producers.Producer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OrderServiceTestSuite {
    private Order prepareOrder() {
        final Producer extraFoodShop = new ExtraFoodShop();
        final Producer glutenFreeShop = new GlutenFreeShop();
        final Producer healthyShop = new HealthyShop();

        Order order = new Order();
        order.addToList(new SingleOrder(extraFoodShop, "Apple", 4));
        order.addToList(new SingleOrder(extraFoodShop, "Pineapple", 2));
        order.addToList(new SingleOrder(extraFoodShop, "Watermelon", 8));
        order.addToList(new SingleOrder(extraFoodShop, "Eggs", 20));
        order.addToList(new SingleOrder(extraFoodShop, "Lemon", 5));
        order.addToList(new SingleOrder(glutenFreeShop, "Lamb", 2));
        order.addToList(new SingleOrder(glutenFreeShop, "Grain Cookies", 4));
        order.addToList(new SingleOrder(glutenFreeShop, "Veal", 3));
        order.addToList(new SingleOrder(glutenFreeShop, "Fish", 10));
        order.addToList(new SingleOrder(glutenFreeShop, "Shrimp", 3));
        order.addToList(new SingleOrder(healthyShop, "Tomato", 20));
        order.addToList(new SingleOrder(healthyShop, "Hot Pepper", 15));
        order.addToList(new SingleOrder(healthyShop, "Spinach", 10));
        order.addToList(new SingleOrder(healthyShop, "Brussels", 9));
        order.addToList(new SingleOrder(healthyShop, "Lemon", 30));
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
