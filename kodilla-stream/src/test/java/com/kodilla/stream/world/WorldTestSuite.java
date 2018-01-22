package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //given
        World earth = new World();
        Continent europe = new Continent();
        Continent asia = new Continent();
        Continent africa = new Continent();
        Continent southAmerica = new Continent();

        earth.addContinent(europe);
        earth.addContinent(asia);
        earth.addContinent(africa);
        earth.addContinent(southAmerica);

        Country poland = new Country(new BigDecimal("38422346"));
        Country germany = new Country(new BigDecimal("82800000"));
        Country scotland = new Country(new BigDecimal("5404700"));
        Country spain = new Country(new BigDecimal("46354321"));
        Country finland = new Country(new BigDecimal("5509717"));
        Country norway = new Country(new BigDecimal("5267146"));
        Country iceland = new Country(new BigDecimal("338349"));
        Country southKorea = new Country(new BigDecimal("51446201"));
        Country china = new Country(new BigDecimal("1403500365"));
        Country japan = new Country(new BigDecimal("126672000"));
        Country thailand = new Country(new BigDecimal("68863514"));
        Country kazakhstan = new Country(new BigDecimal("17987736"));
        Country india = new Country(new BigDecimal("1324171354"));
        Country cambodia = new Country(new BigDecimal("15762370"));
        Country kenya = new Country(new BigDecimal("49125325"));
        Country ethiopia = new Country(new BigDecimal("102403196"));
        Country nigeria = new Country(new BigDecimal("185989640"));
        Country ghana = new Country(new BigDecimal("27043093"));
        Country egypt = new Country(new BigDecimal("96388600"));
        Country tanzania = new Country(new BigDecimal("55572201"));
        Country democraticRepublicOfCongo = new Country(new BigDecimal("78736153"));
        Country argentina = new Country(new BigDecimal("43847430"));
        Country brazil = new Country(new BigDecimal("208385000"));
        Country peru = new Country(new BigDecimal("32553697"));
        Country colombia = new Country(new BigDecimal("49587941"));
        Country chile = new Country(new BigDecimal("17574003"));
        Country bolivia = new Country(new BigDecimal("11217864"));
        Country venezuela = new Country(new BigDecimal("31568179"));

        europe.addCountries(Arrays.asList(poland,germany,scotland,spain,finland,norway,iceland));
        asia.addCountries(Arrays.asList(southKorea,china,japan,thailand,kazakhstan,india,cambodia));
        africa.addCountries(Arrays.asList(kenya,ethiopia,nigeria,ghana,egypt,tanzania,democraticRepublicOfCongo));
        southAmerica.addCountries(Arrays.asList(argentina,brazil,peru,colombia,chile,bolivia,venezuela));

        //when
        BigDecimal totalPopulation = earth.getPeopleQuantity();

        //then
        Assert.assertEquals(new BigDecimal("4182492441"), totalPopulation);
    }
}
