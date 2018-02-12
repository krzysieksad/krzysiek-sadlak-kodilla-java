package com.kodilla.flightcompany;

import java.util.Objects;

public class City {
    private final String cityName;

    City(final String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return Objects.equals(cityName, city.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName);
    }

    public int compare(final City city2) {
        return this.getCityName().compareTo(city2.getCityName());
    }
}
