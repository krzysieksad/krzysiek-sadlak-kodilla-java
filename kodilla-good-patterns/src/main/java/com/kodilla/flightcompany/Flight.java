package com.kodilla.flightcompany;

public class Flight {
    private final String flightFrom;
    private final String flightTo;

    Flight(final String flightFrom, final String flightTo) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    public String getFlightFrom() {
        return flightFrom;
    }

    public String getFlightTo() {
        return flightTo;
    }
}
