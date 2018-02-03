package com.kodilla.good.patterns.challenges.items;

import com.kodilla.good.patterns.challenges.items.Item;

public class Game implements Item {
    private final String gameTitle;

    public Game(final String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public String getGameTitle() {
        return gameTitle;
    }
}
