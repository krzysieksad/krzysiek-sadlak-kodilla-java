package com.kodilla.good.patterns.challenges.items;

public class TShirt implements Item {
    private final String tshirt;
    private final String size;
    private final double price;

    /**
     * T-shirt.
     * @param tshirt model
     * @param size size
     * @param price price
     */
    public TShirt(final String tshirt, final String size, final double price) {
        this.tshirt = tshirt;
        this.size = size;
        this.price = price;
    }

    public String getTShirt() {
        return tshirt;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return tshirt + " in size of " + size + " for " + price;
    }
}
