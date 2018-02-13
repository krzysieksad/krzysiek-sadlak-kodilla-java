package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    @Autowired
    private Display display;

    /**
     * Adding 2 doubles.
     * @param a a
     * @param b b
     * @return double
     */
    public double add(final double a, final double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    /**
     * Subtracting double from double.
     * @param a a
     * @param b b
     * @return double
     */
    public double sub(final double a, final double b) {
        double result = a - b;
        display.displayValue(result);
        return result;
    }

    /**
     * Multiplying 2 doubles.
     * @param a a
     * @param b b
     * @return double
     */
    public double mul(final double a, final double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    /**
     * Dividing double by double.
     * @param a a
     * @param b b
     * @return double
     */
    public double div(final double a, final double b) {
        double result = a / b;
        display.displayValue(result);
        return result;
    }
}