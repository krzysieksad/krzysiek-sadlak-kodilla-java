package com.kodilla.food2door.order;

import com.kodilla.food2door.producers.ProducerId;

public class SingleOrder {
    private final ProducerId producerId;
    private final String product;
    private final int amount;

    /**
     * Single item to order.
     * @param producerId choose producer
     * @param product choose product
     * @param amount choose amount
     */
    public SingleOrder(final ProducerId producerId, final String product, final int amount) {
        this.producerId = producerId;
        this.product = product;
        this.amount = amount;
    }

    public ProducerId getProducerId() {
        return producerId;
    }

    public String getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
