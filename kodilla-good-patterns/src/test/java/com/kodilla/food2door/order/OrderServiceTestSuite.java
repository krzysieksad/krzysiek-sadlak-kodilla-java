package com.kodilla.food2door.order;

import com.kodilla.food2door.producers.ProducerId;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OrderServiceTestSuite {
    private Order prepareOrder() {
        Order order = new Order();
        order.addToList(new SingleOrder(ProducerId.EXTRA_FOOD_SHOP, "Apple", 4));
        order.addToList(new SingleOrder(ProducerId.EXTRA_FOOD_SHOP, "Pineapple", 2));
        order.addToList(new SingleOrder(ProducerId.EXTRA_FOOD_SHOP, "Watermelon", 8));
        order.addToList(new SingleOrder(ProducerId.EXTRA_FOOD_SHOP, "Eggs", 20));
        order.addToList(new SingleOrder(ProducerId.EXTRA_FOOD_SHOP, "Lemon", 5));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Lamb", 2));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Grain Cookies", 4));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Veal", 3));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Fish", 10));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Shrimp", 3));
        order.addToList(new SingleOrder(ProducerId.HEALTHY_SHOP, "Tomato", 20));
        order.addToList(new SingleOrder(ProducerId.HEALTHY_SHOP, "Hot Pepper", 15));
        order.addToList(new SingleOrder(ProducerId.HEALTHY_SHOP, "Spinach", 10));
        order.addToList(new SingleOrder(ProducerId.HEALTHY_SHOP, "Brussels", 9));
        order.addToList(new SingleOrder(ProducerId.HEALTHY_SHOP, "Lemon", 30));
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
        Assert.assertEquals(Arrays.asList("Apple", "Brussels", "Fish", "Grain Cookies", "Hot Pepper", "Lamb", "Lemon", "Pineapple", "Spinach", "Tomato",
                "Watermelon"), orderSummary.getBoughtList());
        Assert.assertEquals(Arrays.asList("Eggs", "Lemon", "Shrimp", "Veal"), orderSummary.getProductsUnavailable());
    }
}
