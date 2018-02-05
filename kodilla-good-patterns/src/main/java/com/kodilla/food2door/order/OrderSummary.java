package com.kodilla.food2door.order;

import java.util.List;

public class OrderSummary {
    private final double paymentAmount;
    private final List<String> boughtList;
    private final List<String> productsUnavailable;

    /**
     * Order summary.
     * @param paymentAmount price to pay
     * @param boughtList list of bought products
     * @param productsUnavailable list of unavailable products
     */
    public OrderSummary(final double paymentAmount, final List<String> boughtList, final List<String> productsUnavailable) {
        this.paymentAmount = paymentAmount;
        this.boughtList = boughtList;
        this.productsUnavailable = productsUnavailable;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public List<String> getBoughtList() {
        return boughtList;
    }

    public List<String> getProductsUnavailable() {
        return productsUnavailable;
    }
}
