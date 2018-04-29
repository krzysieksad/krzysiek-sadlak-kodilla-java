package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(40), calculatedCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Drive a course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(37), calculatedCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testUberWithTwoChildrenSeatsGetCost() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(29), calculatedCost);
    }

    @Test
    public void testUberWithChildrenSeatsGetDescription() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new UberNetworkOrderDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Drive a course by Uber Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getCost());
        //when
        BigDecimal calculatedCost = theOrder.getCost();
        //then
        assertEquals(new BigDecimal(52), calculatedCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        //given
        TaxiOrder theOrder = new BasicTaxiOrder();
        theOrder = new TaxiNetworkOrderDecorator(theOrder);
        theOrder = new VipDecorator(theOrder);
        theOrder = new ChildSeatDecorator(theOrder);
        System.out.println(theOrder.getDescription());
        //when
        String description = theOrder.getDescription();
        //then
        assertEquals("Drive a course by Taxi Network variant VIP + child seat", description);
    }
}