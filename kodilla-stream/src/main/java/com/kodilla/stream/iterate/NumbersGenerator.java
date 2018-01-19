package com.kodilla.stream.iterate;

import java.util.stream.Stream;

public class NumbersGenerator {
    /**
     * Submodule 7.2.
     * @param max max integer.
     */
    public static void generateEven(final int max) {
        Stream.iterate(1, n -> n + 1)
                .limit(max)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
