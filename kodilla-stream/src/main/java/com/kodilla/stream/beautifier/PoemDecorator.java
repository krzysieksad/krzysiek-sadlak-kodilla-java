package com.kodilla.stream.beautifier;

@FunctionalInterface
public interface PoemDecorator {
    String decorate(final String textToDecorate);
}
