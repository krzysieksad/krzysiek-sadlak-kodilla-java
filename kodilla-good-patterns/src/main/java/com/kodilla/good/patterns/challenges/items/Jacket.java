package com.kodilla.good.patterns.challenges.items;

public class Jacket implements Item {
    private final String jacket;

    public Jacket(final String jacket) {
        this.jacket = jacket;
    }

    public String getJacket() {
        return jacket;
    }
}
