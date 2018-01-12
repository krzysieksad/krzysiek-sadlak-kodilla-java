package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private final double height;
    private final double base;

    Triangle(final double height, final double base) {
        this.height = height;
        this.base = base;
    }

    public String getShapeName() {
        return "Triangle";
    }

    public double getField() {
        return ((this.base * this.height) / 2);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.height, height) == 0 &&
                Double.compare(triangle.base, base) == 0;
    }
}
