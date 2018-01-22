package com.kodilla.stream.invoice.simple;

import java.util.Objects;

public class SimpleProduct {
    private final String productName;
    private final double procuctPrice;

    public SimpleProduct(final String productName, final double procuctPrice) {
        this.productName = productName;
        this.procuctPrice = procuctPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProcuctPrice() {
        return procuctPrice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SimpleProduct that = (SimpleProduct) o;
        return Objects.equals(productName, that.productName);
    }
}
