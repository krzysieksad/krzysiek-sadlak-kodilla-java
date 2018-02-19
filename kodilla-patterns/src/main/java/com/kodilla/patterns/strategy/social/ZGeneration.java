package com.kodilla.patterns.strategy.social;

public class ZGeneration extends User {
    public ZGeneration(final String userName) {
        super(userName);
        this.socialPublisher = new SnapchatPublisher();
    }
}
