package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.test.Flight;
import com.kodilla.exception.test.FlightFinder;
import com.kodilla.exception.test.RouteNotFoundException;

public class ExceptionModuleRunner {
    /**
     * Read file.
     * @param args args
     */
    public static void main(final String[] args) {
        FileReader fileReader = new FileReader();
        try {
            fileReader.readFile();
        } catch (FileReaderException e) {
            System.out.println("Problem while reading a file!");
        }

        System.out.println("");

        //Task 8.4.
        FlightFinder flightFinder = new FlightFinder();

        Flight flight1 = new Flight("London", "Moscow");
        Flight flight2 = new Flight("Buenos Aires", "London");
        Flight flight3 = new Flight("Los Angeles", "Oslo");
        try {
            System.out.println("Found flight to " + flight1.getArrivalAirport() + ": " + flightFinder.findFlight(flight1));
            System.out.println("Found flight to " + flight2.getArrivalAirport() + ": " + flightFinder.findFlight(flight2));
            System.out.println("Found flight to " + flight3.getArrivalAirport() + ": " + flightFinder.findFlight(flight3));
        } catch (RouteNotFoundException e) {
            System.out.println("No airport found");
        }
    }
}
