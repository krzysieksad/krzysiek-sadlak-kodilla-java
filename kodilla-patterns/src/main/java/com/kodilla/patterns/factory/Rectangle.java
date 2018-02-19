package com.kodilla.patterns.factory;

public class Rectangle implements Shape {
    private final String name;
    private final double width;
    private final double length;

    /**
     * Submodule 11.4.
     * @param name name
     * @param width width
     * @param length length
     */
    public Rectangle(final String name, final double width, final double length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getField() {
        return width * length;
    }

    @Override
    public double getCircumference() {
        return 2 * width + 2 * length;
    }
}
