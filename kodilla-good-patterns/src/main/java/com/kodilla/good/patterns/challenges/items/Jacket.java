package com.kodilla.good.patterns.challenges.items;

public class Jacket implements Item {
    private final String jacket;
    private final String size;
    private final String material;
    private final double price;

    /**
     * Jacket.
     * @param jacket model
     * @param size size
     * @param material material
     * @param price price
     */
    public Jacket(final String jacket, final String size, final String material, final double price) {
        this.jacket = jacket;
        this.size = size;
        this.material = material;
        this.price = price;
    }

    public String getJacket() {
        return jacket;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return jacket + " made of " + material + " in size of " + size + " for " + price;
    }
}
