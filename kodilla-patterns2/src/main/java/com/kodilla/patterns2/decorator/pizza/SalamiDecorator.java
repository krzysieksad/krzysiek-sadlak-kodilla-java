package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class SalamiDecorator extends AbstractPizzaDecorator {
    public SalamiDecorator(final Pizza pizza) {
        super(pizza);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4.5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", salami";
    }
}
