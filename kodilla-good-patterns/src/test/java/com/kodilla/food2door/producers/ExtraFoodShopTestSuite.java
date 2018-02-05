package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;
import com.kodilla.food2door.order.SingleOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ExtraFoodShopTestSuite {
    private Order prepareOrder() {
        Order order = new Order();
        order.addToList(new SingleOrder("ExtraFoodShop", "Apple", 4));
        order.addToList(new SingleOrder("ExtraFoodShop", "Pineapple", 2));
        order.addToList(new SingleOrder("ExtraFoodShop", "Watermelon", 8));
        order.addToList(new SingleOrder("ExtraFoodShop", "Eggs", 20));
        order.addToList(new SingleOrder("ExtraFoodShop", "Lemon", 5));
        return order;
    }

    @Test
    public void testProcess() {
        //given
        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        Order order = prepareOrder();

        //when
        OrderSummary orderSummary = extraFoodShop.process(order);

        //then
        Assert.assertEquals(67.91, orderSummary.getPaymentAmount(), 0);
        Assert.assertEquals(Arrays.asList("Apple", "Pineapple", "Watermelon", "Lemon"), orderSummary.getBoughtList());
        Assert.assertEquals(Arrays.asList("Eggs"), orderSummary.getProductsUnavailable());
    }
}
