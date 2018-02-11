package com.kodilla.food2door.producers;

import com.kodilla.food2door.order.Order;
import com.kodilla.food2door.order.OrderSummary;
import com.kodilla.food2door.order.SingleOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class GlutenFreeShopTestSuite {
    private Order prepareOrder() {
        Order order = new Order();
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Lamb", 2));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Grain Cookies", 4));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Veal", 3));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Fish", 10));
        order.addToList(new SingleOrder(ProducerId.GLUTEN_FREE_SHOP, "Shrimp", 3));
        return order;
    }

    @Test
    public void testProcess() {
        //given
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
        Order order = prepareOrder();

        //when
        OrderSummary orderSummary = glutenFreeShop.process(order);

        //then
        Assert.assertEquals(536.96, orderSummary.getPaymentAmount(), 0);
        Assert.assertEquals(Arrays.asList("Lamb", "Grain Cookies", "Fish"), orderSummary.getBoughtList());
        Assert.assertEquals(Arrays.asList("Veal", "Shrimp"), orderSummary.getProductsUnavailable());
    }
}
