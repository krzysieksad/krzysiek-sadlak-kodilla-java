package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    private final BigDecimal peopleQuantity;

    Country(final BigDecimal peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return this.peopleQuantity;
    }
}
