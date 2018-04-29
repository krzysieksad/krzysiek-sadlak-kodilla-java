package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaTestSuite {
    @Test
    public void testBasicPizzaGetCost() {
        //given
        Pizza pizza = new BasicPizza();
        //when
        BigDecimal calculatedCost = pizza.getCost();
        //then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaGetDescription() {
        //given
        Pizza pizza = new BasicPizza();
        //when
        String description = pizza.getDescription();
        //then
        assertEquals("Ingredients: Dough, tomato sauce, cheese", description);
    }

    @Test
    public void testPizzaWithSalamiOnionGetCost() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new SalamiDecorator(pizza);
        pizza = new OnionDecorator(pizza);
        //when
        BigDecimal calculatedCost = pizza.getCost();
        //then
        assertEquals(new BigDecimal(22.5), calculatedCost);
    }

    @Test
    public void testPizzaWithSalamiOnionGetDescription() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new SalamiDecorator(pizza);
        pizza = new OnionDecorator(pizza);
        //when
        String description = pizza.getDescription();
        //then
        assertEquals("Ingredients: Dough, tomato sauce, cheese, salami, onion", description);
    }

    @Test
    public void testPizzaWithBaconMushroomsHotPeppersGetCost() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new BaconDecorator(pizza);
        pizza = new MushroomsDecorator(pizza);
        pizza = new HotPeppersDecorator(pizza);
        //when
        BigDecimal calculatedCost = pizza.getCost();
        //then
        assertEquals(new BigDecimal(25.5), calculatedCost);
    }

    @Test
    public void testPizzaWithBaconMushroomsHotPeppersGetDescription() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new BaconDecorator(pizza);
        pizza = new MushroomsDecorator(pizza);
        pizza = new HotPeppersDecorator(pizza);
        //when
        String description = pizza.getDescription();
        //then
        assertEquals("Ingredients: Dough, tomato sauce, cheese, bacon, mushrooms, hot peppers", description);
    }

    @Test
    public void testPizzaWithEverythingGetCost() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new BaconDecorator(pizza);
        pizza = new MushroomsDecorator(pizza);
        pizza = new HotPeppersDecorator(pizza);
        pizza = new SalamiDecorator(pizza);
        pizza = new OnionDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        //when
        BigDecimal calculatedCost = pizza.getCost();
        //then
        assertEquals(new BigDecimal(37.0).setScale(1, BigDecimal.ROUND_UNNECESSARY), calculatedCost);
    }

    @Test
    public void testPizzaWithEverythingGetDescription() {
        //given
        Pizza pizza = new BasicPizza();
        pizza = new BaconDecorator(pizza);
        pizza = new MushroomsDecorator(pizza);
        pizza = new HotPeppersDecorator(pizza);
        pizza = new SalamiDecorator(pizza);
        pizza = new OnionDecorator(pizza);
        pizza = new ExtraCheeseDecorator(pizza);
        //when
        String description = pizza.getDescription();
        //then
        assertEquals("Ingredients: Dough, tomato sauce, cheese, bacon, mushrooms, hot peppers, salami, onion, extra cheese", description);
    }
}