package com.kodilla.testing.shape;

public class Square implements Shape {
    private final double side;

    Square(final double side) {
        this.side = side;
    }

    public String getShapeName() {
        return "Square";
    }

    public double getField() {
        return Math.pow(side, 2);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0;
    }
}
