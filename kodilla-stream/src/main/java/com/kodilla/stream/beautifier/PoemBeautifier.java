package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(final String poem, final PoemDecorator decorator) {
        System.out.println(decorator.decorate(poem));
    }
}
