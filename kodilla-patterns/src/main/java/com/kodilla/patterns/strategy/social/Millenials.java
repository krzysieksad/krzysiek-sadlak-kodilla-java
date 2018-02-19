package com.kodilla.patterns.strategy.social;

public class Millenials extends User {
    public Millenials(final String userName) {
        super(userName);
        this.socialPublisher = new TwitterPublisher();
    }
}
