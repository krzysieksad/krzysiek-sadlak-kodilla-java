package com.kodilla.exception.test;

public class FirstChallenge {
    /**
     * Divides number by number.
     * @param a number to divide
     * @param b divide by
     * @return result
     * @throws ArithmeticException if second argument is 0
     */
    public double divide(final double a, final double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!.
     * @param args standard main argument
     */
    public static void main(final String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        try {
            double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("You can't divide by 0!");
        } finally {
            System.out.println("Done!");
        }

    }
}
