package com.kodilla.flightcompany;

import java.util.Objects;

public class Flight {
    private final City flightFrom;
    private final City flightTo;

    Flight(final City flightFrom, final City flightTo) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
    }

    public City getFlightFrom() {
        return flightFrom;
    }

    public City getFlightTo() {
        return flightTo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Flight flight = (Flight) o;
        return Objects.equals(flightFrom, flight.flightFrom) &&
                Objects.equals(flightTo, flight.flightTo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flightFrom, flightTo);
    }
}
