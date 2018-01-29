package com.kodilla.exception.test;

public class SecondChallenge {
    /**
     * Task 8.3.
     * @param x parameter x
     * @param y parameter y
     * @return if ok
     * @throws Exception handeled
     */
    public String probablyIWillThrowException(final double x, final double y) throws Exception {
        if (x >= 2 || x < 1 || y == 1.5) {
            throw new Exception();
        }
        return "Done!";
    }
}
