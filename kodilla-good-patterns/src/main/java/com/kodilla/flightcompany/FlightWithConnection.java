package com.kodilla.flightcompany;

import java.util.Objects;

public class FlightWithConnection implements Flight {
    private final City flightFrom;
    private final City flightTo;
    private final City connectionCity;

    FlightWithConnection(final City flightFrom, final City flightTo, final City connectionCity) {
        this.flightFrom = flightFrom;
        this.flightTo = flightTo;
        this.connectionCity = connectionCity;
    }

    public City getFlightFrom() {
        return flightFrom;
    }

    public City getFlightTo() {
        return flightTo;
    }

    public City getConnectionCity() {
        return connectionCity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FlightWithConnection flightWithConnection = (FlightWithConnection) o;
        return Objects.equals(flightFrom, flightWithConnection.flightFrom) &&
                Objects.equals(flightTo, flightWithConnection.flightTo) &&
                Objects.equals(connectionCity, flightWithConnection.connectionCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightFrom, flightTo, connectionCity);
    }
}
