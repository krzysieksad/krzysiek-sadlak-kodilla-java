package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private final List<Shape> shapes;

    ShapeCollector() {
        this.shapes = new ArrayList<>();
    }

    public void addFigure(final Shape shape) {
        this.shapes.add(shape);
    }

    boolean removeFigure(final Shape shape) {
        return this.shapes.remove(shape);
    }

    Shape getFigure(final int n) {
        if (this.shapes.size() > n) {
            return this.shapes.get(n);
        } else {
            return null;
        }
    }

    public List<Shape> showFigures() {
        return this.shapes;
    }
}
