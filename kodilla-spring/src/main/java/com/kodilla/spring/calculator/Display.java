package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Display {
    public void displayValue(final double val) {
        System.out.println("The result of equation is " + val);
    }
}
