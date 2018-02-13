package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
    @Autowired
    private Display display;

    public double add(final double a, final double b) {
        return 0;
    }
    public double sub(final double a, final double b) {
        return 0;
    }
    public double mul(final double a, final double b) {
        return 0;
    }
    public double div(final double a, final double b) {
        return 0;
    }
}
