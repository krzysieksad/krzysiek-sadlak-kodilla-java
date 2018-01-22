package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private final List<Country> countryList = new ArrayList<>();

    public List<Country> getCountryList() {
        return countryList;
    }

    public void addCountry(final Country country) {
        countryList.add(country);
    }

    public void addCountries(final List<Country> countryList) {
        this.countryList.addAll(countryList);
    }
}
