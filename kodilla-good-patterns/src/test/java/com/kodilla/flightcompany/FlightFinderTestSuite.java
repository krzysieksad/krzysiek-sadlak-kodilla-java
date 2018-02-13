package com.kodilla.flightcompany;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightFinderTestSuite {
    private final City krakow = new City("Kraków");
    private final City warszawa = new City("Warszawa");
    private final City gdansk = new City("Gdańsk");
    private final City lublin = new City("Lublin");
    private final City katowice = new City("Katowice");
    private final City zakopane = new City("Zakopane");
    private final City wroclaw = new City("Wrocław");

    private FlightOffers prepareTestData() {
        FlightOffers company = new FlightOffers();

        company.changeDestinationsList(krakow, Arrays.asList(wroclaw, warszawa, katowice, lublin));
        company.changeDestinationsList(warszawa, Arrays.asList(krakow, wroclaw, zakopane, lublin, katowice));
        company.changeDestinationsList(gdansk, Arrays.asList(krakow, warszawa, katowice));
        company.changeDestinationsList(lublin, Arrays.asList(katowice, gdansk));
        company.changeDestinationsList(wroclaw, Arrays.asList(krakow, gdansk, zakopane));
        company.changeDestinationsList(katowice, Arrays.asList(lublin, krakow, gdansk, wroclaw));
        company.changeDestinationsList(zakopane, Arrays.asList(lublin, warszawa));
        company.changeDeparturesList(krakow, Arrays.asList(warszawa, gdansk, wroclaw, katowice));
        company.changeDeparturesList(warszawa, Arrays.asList(krakow, gdansk, zakopane));
        company.changeDeparturesList(gdansk, Arrays.asList(wroclaw, katowice, lublin));
        company.changeDeparturesList(lublin, Arrays.asList(krakow, katowice, warszawa, zakopane));
        company.changeDeparturesList(wroclaw, Arrays.asList(krakow, warszawa, katowice));
        company.changeDeparturesList(katowice, Arrays.asList(krakow, lublin, gdansk, warszawa));
        company.changeDeparturesList(zakopane, Arrays.asList(warszawa, wroclaw));

        return company;
    }

    @Test
    public void testFindFlightsFromCity() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<Flight> searchResults = finder.findFlightsFromCity(new City("Warszawa"));

        //then
        Assert.assertEquals(Arrays.asList(new DirectFlight(warszawa, katowice),
                new DirectFlight(warszawa, krakow),
                new DirectFlight(warszawa, lublin),
                new DirectFlight(warszawa, wroclaw),
                new DirectFlight(warszawa, zakopane)), searchResults);
    }

    @Test
    public void testFindFlightsToCity() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<Flight> searchResults = finder.findFlightsToCity(new City("Warszawa"));

        //then
        Assert.assertEquals(Arrays.asList(new DirectFlight(gdansk, warszawa),
                new DirectFlight(krakow, warszawa),
                new DirectFlight(zakopane, warszawa)), searchResults);

    }

    @Test
    public void testFindFlightsWithConnection() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<Flight> searchResults = finder.findFlightsWithConnection(new City("Kraków"), new City("Gdańsk"));

        //then
        Assert.assertEquals(Arrays.asList(new FlightWithConnection(krakow, gdansk, katowice),
                new FlightWithConnection(krakow, gdansk, lublin),
                new FlightWithConnection(krakow, gdansk, wroclaw)), searchResults);
    }

    @Test
    public void testFlightsWithConnectionNotFound() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<Flight> searchResults = finder.findFlightsWithConnection(new City("Lublin"), new City("Zakopane"));

        //then
        Assert.assertEquals(new ArrayList<Flight>(), searchResults);
    }
}
