package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
    private final Map<String, Boolean> flights = new HashMap<>();

    /**
     * Create Flight list.
     */
    public FlightFinder() {
        flights.put("Barcelona", true);
        flights.put("London", false);
        flights.put("Moscow", true);
        flights.put("Sydney", true);
        flights.put("Buenos Aires", true);
        flights.put("Los Ageles", false);
        flights.put("Tokio", true);
    }

    /**
     * Task 8.4.
     * @param flight search for flight
     * @return is possible to fly
     */
    public boolean findFlight(final Flight flight) throws RouteNotFoundException {



        if (flights.containsKey(flight.getArrivalAirport())) {
            return flights.get(flight.getArrivalAirport());
        } else {
            throw new RouteNotFoundException();
        }
    }
}
