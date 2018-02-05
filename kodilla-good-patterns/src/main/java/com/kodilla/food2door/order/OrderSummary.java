package com.kodilla.food2door.order;

import java.util.ArrayList;
import java.util.List;

public class OrderSummary {
    private final double paymentAmount = 0;
    private final List<String> boughtList = new ArrayList<>();
    private final List<String> productsUnavailable = new ArrayList<>();

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public List<String> getBoughtList() {
        return boughtList;
    }

    public List<String> getProductsUnavailable() {
        return productsUnavailable;
    }

    public void addPrice(final double price) {
    }

    public void addProductToBoughtList(final String product) {
    }

    public void addProductToUnavailableList(final String product) {
    }
}
