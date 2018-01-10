package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
=    /**
     * This is JavaDoc.
     * @param args just argument.
     */
    public static void main(final String[] args) {
        Calculator calculator = new Calculator();

        if (calculator.add(5,17) == 22) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test FAILED");
        }

        if (calculator.subtract(51,36) == 15) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test FAILED");
        }
    }
}
