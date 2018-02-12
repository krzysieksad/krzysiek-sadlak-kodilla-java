package com.kodilla.flightcompany;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class FlightOffers {
    private final Map<City, List<City>> flightsFrom = new HashMap<>();
    private final Map<City, List<City>> flightsTo = new HashMap<>();

    public void changeDestinationsList(final City departureCity, final List<City> destinations) {
        flightsFrom.put(departureCity, destinations);
    }

    public void changeDeparturesList(final City arrivalCity, final List<City> departures) {
        flightsTo.put(arrivalCity, departures);
    }

    public Map<City, List<City>> getFlightsFrom() {
        return flightsFrom;
    }

    public Map<City, List<City>> getFlightsTo() {
        return flightsTo;
    }
}
