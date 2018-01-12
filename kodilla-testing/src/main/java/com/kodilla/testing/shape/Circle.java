package com.kodilla.testing.shape;

public class Circle implements Shape {
    private final double radius;

    Circle(final double radius) {
        this.radius = radius;
    }

    public String getShapeName() {
        return "Circle";
    }

    public double getField() {
        return (Math.PI * Math.pow(radius, 2));
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }
}
