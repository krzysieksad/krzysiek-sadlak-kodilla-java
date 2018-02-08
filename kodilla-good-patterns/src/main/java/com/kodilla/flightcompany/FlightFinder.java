package com.kodilla.flightcompany;

import java.util.ArrayList;
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

    /**
     * Get all flights from city to city with one connection.
     * @param fromCity departure city
     * @param toCity arrival city
     * @return list of flights
     */
    public List<String> findFlightsWithConnection(final City fromCity, final City toCity) {
        List<String> midCities = companyFlights.getFlightList().stream()
                .filter(flight -> flight.getFlightFrom().equals(fromCity))
                .map(Flight::getFlightTo)
                .collect(Collectors.toList()).stream()
                .filter(city ->
                        companyFlights.getFlightList().stream()
                                .filter(flight -> flight.getFlightTo().equals(toCity))
                                .map(Flight::getFlightFrom)
                                .collect(Collectors.toList())
                                .contains(city))
                .map(City::getCityName)
                .sorted()
                .collect(Collectors.toList());

        return midCities.stream()
                .map(s -> fromCity.getCityName() + " -> " + s + " -> " + toCity.getCityName())
                .collect(Collectors.toList());
    }
}
