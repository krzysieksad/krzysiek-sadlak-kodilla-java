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
     * @param departureCity departure departureCity
     * @return list of destinations
     */
    public List<Flight> findFlightsFromCity(final City departureCity) {
        return companyFlights.getFlightsFrom().get(departureCity).stream()
                .map(city -> new DirectFlight(departureCity, city))
                .collect(Collectors.toList()).stream()
                .sorted(DirectFlight.CompareDirectFlights)
                .collect(Collectors.toList());
    }

    /**
     * Get all departure cities.
     * @param arrivalCity arrival arrivalCity
     * @return list of departures
     */
    public List<Flight> findFlightsToCity(final City arrivalCity) {
        return companyFlights.getFlightsTo().get(arrivalCity).stream()
                .map(city -> new DirectFlight(city, arrivalCity))
                .collect(Collectors.toList()).stream()
                .sorted(DirectFlight.CompareDirectFlights)
                .collect(Collectors.toList());
    }

    /**
     * Get all flights from city to city with one connection.
     * @param fromCity departure city
     * @param toCity arrival city
     * @return list of flights
     */
    public List<Flight> findFlightsWithConnection(final City fromCity, final City toCity) {
        List<City> possibleMidCities = companyFlights.getFlightsFrom().get(fromCity);
        List<City> midCities = companyFlights.getFlightsTo().get(toCity).stream()
                .filter(possibleMidCities::contains)
                .sorted(City::compare)
                .collect(Collectors.toList());

        return midCities.stream()
                .map(s -> new FlightWithConnection(fromCity, toCity, s))
                .collect(Collectors.toList());
    }
}
