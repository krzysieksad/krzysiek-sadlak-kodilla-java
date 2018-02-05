package com.kodilla.good.patterns.challenges.items;


public class Game implements Item {
    private final String gameTitle;
    private final double price;

    public Game(final String gameTitle, final double price) {
        this.gameTitle = gameTitle;
        this.price = price;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return gameTitle + " for " + price;
    }
}
