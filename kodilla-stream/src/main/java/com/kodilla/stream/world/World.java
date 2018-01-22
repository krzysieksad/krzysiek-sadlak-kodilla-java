package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<Continent> continentList = new ArrayList<>();

    /**
     * Counts people quantity on chosen world.
     * @return BigDecimal.
     */
    public BigDecimal getPeopleQuantity() {
        return continentList.stream()
                .flatMap(country -> country.getCountryList().stream())
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, population) -> sum = sum.add(population));
    }

    public void addContinent(final Continent continent) {
        continentList.add(continent);
    }
}
