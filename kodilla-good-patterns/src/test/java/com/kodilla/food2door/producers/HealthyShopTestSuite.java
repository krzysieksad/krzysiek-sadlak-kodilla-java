package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;
import com.kodilla.food2door.order.SingleOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class HealthyShopTestSuite {
    private Order prepareOrder() {
        Order order = new Order();
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
        HealthyShop healthyShop = new HealthyShop();
        Order order = prepareOrder();

        //when
        OrderSummary orderSummary = healthyShop.process(order);

        //then
        Assert.assertEquals(355.85, orderSummary.getPaymentAmount(), 0);
        Assert.assertEquals(Arrays.asList("Tomato", "Hot Pepper", "Spinach", "Brussels"), orderSummary.getBoughtList());
        Assert.assertEquals(Arrays.asList("Lemon"), orderSummary.getProductsUnavailable());
    }
}
