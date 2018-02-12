package com.kodilla.flightcompany;

import java.util.Comparator;
import java.util.Objects;

public class DirectFlight implements Flight {
    private final City flightFrom;
    private final City flightTo;

    DirectFlight(final City flightFrom, final City flightTo) {
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
        DirectFlight directFlight = (DirectFlight) o;
        return Objects.equals(flightFrom, directFlight.flightFrom) &&
                Objects.equals(flightTo, directFlight.flightTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightFrom, flightTo);
    }

    public static Comparator<Flight> CompareDirectFlights = (o1, o2) -> {
        int flightFrom = o1.getFlightFrom().compare(o2.getFlightFrom());
        if (flightFrom == 0) {
            return o1.getFlightTo().compare(o2.getFlightTo());
        } else {
            return flightFrom;
        }
    };
}
