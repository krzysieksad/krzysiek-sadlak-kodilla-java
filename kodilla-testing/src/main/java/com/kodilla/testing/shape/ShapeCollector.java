package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    private final List<Shape> shapes;

    ShapeCollector() {
        this.shapes = new ArrayList<>();
    }

    public void addFigure(final Shape shape) {
    }

    public boolean removeFigure(final Shape shape) {
        return true;
    }

    public Shape getFigure(final int n) {
        return null;
    }

    public List<Shape> showFigures() {
        return null;
    }
}
