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
    public List<String> findFlightsFromCity(final String city) {
        return companyFlights.getFlightList().stream()
                .filter(flight -> flight.getFlightFrom().equals(city))
                .map(Flight::getFlightTo)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Get all departure cities.
     * @param city arrival city
     * @return list of departures
     */
    public List<String> findFlightsToCity(final String city) {
        return companyFlights.getFlightList().stream()
                .filter(flight -> flight.getFlightTo().equals(city))
                .map(Flight::getFlightFrom)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<String> findFlightsFromCityToCity(final String fromCity, final String toCity, final int maxConnections) {
        return null;
    }
}
