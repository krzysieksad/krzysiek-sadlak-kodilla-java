package com.kodilla.flightcompany;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlightFinderTestSuite {
    private FlightOffers prepareTestData() {
        FlightOffers company = new FlightOffers();
        City krakow = new City("Kraków");
        City warszawa = new City("Warszawa");
        City gdansk = new City("Gdańsk");
        City lublin = new City("Lublin");
        City katowice = new City("Katowice");
        City zakopane = new City("Zakopane");
        City wroclaw = new City("Wrocław");

        company.addNewFlight(new Flight(krakow, wroclaw));
        company.addNewFlight(new Flight(krakow, warszawa));
        company.addNewFlight(new Flight(krakow, katowice));
        company.addNewFlight(new Flight(krakow, lublin));
        company.addNewFlight(new Flight(warszawa, krakow));
        company.addNewFlight(new Flight(gdansk, krakow));
        company.addNewFlight(new Flight(lublin, katowice));
        company.addNewFlight(new Flight(warszawa, wroclaw));
        company.addNewFlight(new Flight(warszawa, zakopane));
        company.addNewFlight(new Flight(wroclaw, krakow));
        company.addNewFlight(new Flight(katowice, lublin));
        company.addNewFlight(new Flight(warszawa, lublin));
        company.addNewFlight(new Flight(katowice, krakow));
        company.addNewFlight(new Flight(zakopane, lublin));
        company.addNewFlight(new Flight(gdansk, warszawa));
        company.addNewFlight(new Flight(lublin, zakopane));
        company.addNewFlight(new Flight(gdansk, katowice));
        company.addNewFlight(new Flight(wroclaw, gdansk));
        company.addNewFlight(new Flight(warszawa, katowice));
        company.addNewFlight(new Flight(wroclaw, zakopane));
        company.addNewFlight(new Flight(katowice, gdansk));
        company.addNewFlight(new Flight(zakopane, warszawa));
        company.addNewFlight(new Flight(lublin, gdansk));
        company.addNewFlight(new Flight(katowice, wroclaw));




        return company;
    }

    @Test
    public void testFindFlightsFromCity() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<String> searchResults = finder.findFlightsFromCity(new City("Warszawa"));

        //then
        Assert.assertEquals(Arrays.asList("Katowice", "Kraków", "Lublin", "Wrocław", "Zakopane"), searchResults);
    }

    @Test
    public void testFindFlightsToCity() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<String> searchResults = finder.findFlightsToCity(new City("Warszawa"));

        //then
        Assert.assertEquals(Arrays.asList("Gdańsk", "Kraków", "Zakopane"), searchResults);
    }

    @Test
    public void testFindDirectFlightsFromCityToCity() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<String> searchResults = finder.findFlightsFromCityToCity(new City("Katowice"), new City("Lublin"), 0);

        //then
        Assert.assertEquals(Arrays.asList("Katowice -> Lublin"), searchResults);
    }

    @Test
    public void testFindFlightsFromCityToCity1Connection() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<String> searchResults = finder.findFlightsFromCityToCity(new City("Katowice"), new City("Lublin"), 1);

        //then
        Assert.assertEquals(Arrays.asList("Katowice -> Kraków -> Lublin", "Katowice -> Lublin"), searchResults);
    }

    @Test
    public void testFindFlightsFromCityToCity3Connections() {
        //given
        FlightOffers companyFlights = prepareTestData();
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<String> searchResults = finder.findFlightsFromCityToCity(new City("Katowice"), new City("Lublin"), 2);

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
        FlightFinder finder = new FlightFinder(companyFlights);

        //when
        List<String> searchResults = finder.findFlightsFromCityToCity(new City("Zakopane"), new City("Kraków"), 0);

        //then
        Assert.assertEquals(new ArrayList<String>(), searchResults);
    }
}
