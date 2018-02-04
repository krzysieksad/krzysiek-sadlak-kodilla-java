package com.kodilla.good.patterns.challenges.items;

public class Tshirt implements Item {
    private final String tshirt;

    public Tshirt(final String tshirt) {
        this.tshirt = tshirt;
    }

    public String getTshirt() {
        return tshirt;
    }
}
