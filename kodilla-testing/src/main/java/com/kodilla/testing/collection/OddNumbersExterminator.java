package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    /**
     * Exterminating odd numbers.
     * @param numbers List with numbers.
     * @return only even numbers.
     */
    public List<Integer> exterminate(final List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        return evenNumbers;
    }
}
