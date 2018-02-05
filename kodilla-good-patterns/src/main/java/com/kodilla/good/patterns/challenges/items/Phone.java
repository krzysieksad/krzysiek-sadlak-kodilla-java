package com.kodilla.good.patterns.challenges.items;

public class Phone implements Item {
    private final String phoneProducer;
    private final String phoneModel;
    private final double price;

    /**
     * Mobile phone.
     * @param phoneProducer produced by
     * @param phoneModel model name
     * @param price price
     */
    public Phone(final String phoneProducer, final String phoneModel, final double price) {
        this.phoneProducer = phoneProducer;
        this.phoneModel = phoneModel;
        this.price = price;
    }

    public String getPhoneProducer() {
        return phoneProducer;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return phoneProducer + ", model " + phoneModel + " for " + price;
    }
}
