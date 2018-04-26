package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    @Autowired
    private Authenticator authenticator;
    @Autowired
    private ProductService productService;

    /**
     * Submodule 20.1. Open new order.
     *
     * @param userId Order for user
     * @return orderId
     */
    public Long openOrder(final Long userId) {
        if (authenticator.isAuthenticated(userId)) {
            Long maxOrder = (long) orders.stream()
                    .mapToInt(o -> o.getOrderId().intValue())
                    .max().orElse(0);
            orders.add(new Order(maxOrder + 1, userId, productService));
            return maxOrder + 1;
        } else {
            return -1L;
        }
    }

    /**
     * Submodule 20.1. Add new item to order.
     *
     * @param orderId   orderId
     * @param productId productId
     * @param qty       quantity
     */
    public void addItem(final long orderId, final Long productId, final double qty) {
        orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .forEach(o -> o.getItems().add(new Item(productId, qty)));
    }

    /**
     * Submodule 20.1. Remove item from order.
     *
     * @param orderId   orderId
     * @param productId productId
     * @return isRemoved
     */
    public boolean removeItem(final Long orderId, final Long productId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();

        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            int orderSize = theOrder.getItems().size();
            for (int n = 0; n < theOrder.getItems().size(); n++) {
                if (theOrder.getItems().get(n).getProductId().equals(productId)) {
                    theOrder.getItems().remove(n);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Submodule 20.1. Calculate value of order.
     *
     * @param orderId orderId
     * @return value
     */
    public BigDecimal calculateValue(final Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            return theOrder.calculateValue();
        }
        return BigDecimal.ZERO;
    }

    /**
     * Submodule 20.1. Pay for order.
     *
     * @param orderId orderId
     * @return isPaid
     */
    public boolean doPayment(final Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.isPaid()) {
                return true;
            } else {
                Random generator = new Random();
                theOrder.setPaid(generator.nextBoolean());
                return theOrder.isPaid();
            }
        }
        return false;
    }

    /**
     * Submodule 20.1. Verifying validity of order;
     *
     * @param orderId orderId
     * @return isVerified
     */
    public boolean verifyOrder(final Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            boolean result = theOrder.isPaid();
            Random generator = new Random();
            if (!theOrder.isVerified()) {
                theOrder.setVerified(result && generator.nextBoolean());
            }
            return theOrder.isVerified();
        }
        return false;
    }

    /**
     * Submodule 20.1. Submitting order.
     *
     * @param orderId orderId
     * @return isSubmitted
     */
    public boolean submitOrder(final Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            if (theOrder.isVerified()) {
                theOrder.setSubmitted(true);
            }
            return theOrder.isSubmitted();
        }
        return false;
    }

    /**
     * Submodule 20.1. Remove order.
     *
     * @param orderId orderId
     */
    public void cancelOrder(final Long orderId) {
        Iterator<Order> orderIterator = orders.stream()
                .filter(o -> o.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            Order theOrder = orderIterator.next();
            orders.remove(theOrder);
        }
    }
}
