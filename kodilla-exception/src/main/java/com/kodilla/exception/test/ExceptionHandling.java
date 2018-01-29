package com.kodilla.exception.test;

public class ExceptionHandling {
    /**
     * Task 8.3.
     * @param args args.
     */
    public static void main(final String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            System.out.println(secondChallenge.probablyIWillThrowException(2.0, 3.0));
        } catch (Exception e) {
            System.out.println("Oh no!");
        } finally {
            System.out.println("Handeled");
        }

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(1.5, 3.0));
        } catch (Exception e) {
            System.out.println("Oh no!");
        } finally {
            System.out.println("Handeled");
        }
    }
}
