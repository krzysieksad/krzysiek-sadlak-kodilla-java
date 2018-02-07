package com.kodilla.flightcompany;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFinder {
    private final FlightOffers companyFlights;

    FlightFinder(final FlightOffers companyFlights) {
        this.companyFlights = companyFlights;
    }

    /**
     * Get all destination cities.
     * @param city departure city
     * @return list of destinations
     */
    public List<String> findFlightsFromCity(final City city) {
        return companyFlights.getFlightList().stream()
                .filter(flight -> flight.getFlightFrom().equals(city))
                .map(Flight::getFlightTo)
                .map(City::getCityName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Get all departure cities.
     * @param city arrival city
     * @return list of departures
     */
    public List<String> findFlightsToCity(final City city) {
        return companyFlights.getFlightList().stream()
                .filter(flight -> flight.getFlightTo().equals(city))
                .map(Flight::getFlightFrom)
                .map(City::getCityName)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> findFlightsFromCityToCity(final City fromCity, final City toCity, final int maxConnections) {
        return null;
    }
}
