package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    /**
     * Counts average of numbers from table.
     * @param numbers table.
     * @return double.
     */
    static OptionalDouble getAverage(int[] numbers) {
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average();
    }
}
