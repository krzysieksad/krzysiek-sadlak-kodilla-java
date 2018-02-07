package com.kodilla.flightcompany;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightFinderTestSuite {
    private FlightOffers prepareTestData() {
        FlightOffers company = new FlightOffers();

        company.addNewFlight(new Flight("Kraków", "Wrocław"));
        company.addNewFlight(new Flight("Kraków", "Warszawa"));
        company.addNewFlight(new Flight("Kraków", "Katowice"));
        company.addNewFlight(new Flight("Kraków", "Lublin"));
        company.addNewFlight(new Flight("Warszawa", "Kraków"));
        company.addNewFlight(new Flight("Gdańsk", "Kraków"));
        company.addNewFlight(new Flight("Lublin", "Katowice"));
        company.addNewFlight(new Flight("Warszawa", "Wrocław"));
        company.addNewFlight(new Flight("Warszawa", "Zakopane"));
        company.addNewFlight(new Flight("Wrocław", "Kraków"));
        company.addNewFlight(new Flight("Katowice", "Lublin"));
        company.addNewFlight(new Flight("Warszawa", "Lublin"));
        company.addNewFlight(new Flight("Katowice", "Kraków"));
        company.addNewFlight(new Flight("Zakopane", "Lublin"));
        company.addNewFlight(new Flight("Gdańsk", "Warszawa"));
        company.addNewFlight(new Flight("Lublin", "Zakopane"));
        company.addNewFlight(new Flight("Gdańsk", "Katowice"));
        company.addNewFlight(new Flight("Wrocław", "Gdańsk"));
        company.addNewFlight(new Flight("Warszawa", "Katowice"));
        company.addNewFlight(new Flight("Wrocław", "Zakopane"));
        company.addNewFlight(new Flight("Katowice", "Gdańsk"));
        company.addNewFlight(new Flight("Zakopane", "Warszawa"));
        company.addNewFlight(new Flight("Lublin", "Gdańsk"));
        company.addNewFlight(new Flight("Katowice", "Wrocław"));

        return company;
    }

    @Test
    public void testFindFlightsFromCity() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder();

        //when
        List<String> searchResults = finder.findFlightsFromCity("Warszawa");

        //then
        Assert.assertEquals(Arrays.asList("Katowice", "Kraków", "Lublin", "Wrocław", "Zakopane"), searchResults);
    }

    @Test
    public void testFindFlightsToCity() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder();

        //when
        List<String> searchResults = finder.findFlightsToCity("Warszawa");

        //then
        Assert.assertEquals(Arrays.asList("Gdańsk", "Kraków", "Zakopane"), searchResults);
    }

    @Test
    public void testFindDirectFlightsFromCityToCity() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder();

        //when
        List<String> searchResults = finder.findFlightsFromCityToCity("Katowice", "Lublin", 0);

        //then
        Assert.assertEquals(Arrays.asList("Katowice -> Lublin"), searchResults);
    }

    @Test
    public void testFindFlightsFromCityToCity1Connection() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder();

        //when
        List<String> searchResults = finder.findFlightsFromCityToCity("Katowice", "Lublin", 1);

        //then
        Assert.assertEquals(Arrays.asList("Katowice -> Kraków -> Lublin", "Katowice -> Lublin"), searchResults);
    }

    @Test
    public void testFindFlightsFromCityToCity3Connections() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder();

        //when
        List<String> searchResults = finder.findFlightsFromCityToCity("Katowice", "Lublin", 2);

        //then
        Assert.assertEquals(Arrays.asList("Katowice -> Gdańsk -> Katowice -> Lublin",
                "Katowice -> Gdańsk -> Kraków -> Lublin",
                "Katowice -> Gdańsk -> Warszawa -> Lublin",
                "Katowice -> Kraków -> Lublin",
                "Katowice -> Kraków -> Warszawa -> Lublin",
                "Katowice -> Kraków -> Katowice -> Lublin",
                "Katowice -> Lublin",
                "Katowice -> Wrocław -> Kraków -> Lublin",
                "Katowice -> Wrocław -> Zakopane -> Lublin"),
                searchResults);
    }

    @Test
    public void testFlightsFromCityToCityNotFound() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder();

        //when
        List<String> searchResults = finder.findFlightsFromCityToCity("Zakopane", "Kraków", 0);

        //then
        Assert.assertEquals(new ArrayList<String>(), searchResults);
    }
}
