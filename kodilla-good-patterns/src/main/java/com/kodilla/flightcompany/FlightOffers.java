package com.kodilla.flightcompany;

import java.util.ArrayList;
import java.util.List;

public class FlightOffers {
    private final List<Flight> flightList = new ArrayList<>();

    public void addNewFlight(final Flight flight) {
        flightList.add(flight);
    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}
