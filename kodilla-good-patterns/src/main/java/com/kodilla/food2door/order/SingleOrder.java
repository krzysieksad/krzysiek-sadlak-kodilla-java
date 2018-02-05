package com.kodilla.food2door.order;

public class SingleOrder {
    private final String producer;
    private final String product;
    private final int amount;

    /**
     * Single item to order.
     * @param producer choose producer
     * @param product choose product
     * @param amount choose amount
     */
    public SingleOrder(final String producer, final String product, final int amount) {
        this.producer = producer;
        this.product = product;
        this.amount = amount;
    }

    public String getProducer() {
        return producer;
    }

    public String getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
