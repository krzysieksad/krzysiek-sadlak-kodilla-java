package com.kodilla.good.patterns.challenges.items;

public class TShirt implements Item {
    private final String tShirt;
    private final String size;
    private final double price;

    /**
     * T-shirt.
     * @param tShirt model
     * @param size size
     * @param price price
     */
    public TShirt(final String tShirt, final String size, final double price) {
        this.tShirt = tShirt;
        this.size = size;
        this.price = price;
    }

    public String getTShirt() {
        return tShirt;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return tShirt + " in size of " + size + " for " + price;
    }
}
