package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<Continent> continentList = new ArrayList<>();

    public BigDecimal getPeopleQuantity() {
        return BigDecimal.ZERO;
    }

    public void addContinent(final Continent continent) {
        continentList.add(continent);
    }
}
