package com.kodilla.testing.shape;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite {
    @Test
    public void testAddFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Triangle(5, 3));
        Assert.assertEquals(shapeCollector.showFigures().size(), 1);
    }

    @Test
    public void testRemoveFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Triangle(5, 3));
        boolean removal = shapeCollector.removeFigure(new Triangle(5, 3));
        Assert.assertTrue(removal);
        Assert.assertEquals(shapeCollector.showFigures().size(), 0);
    }

    @Test
    public void testRemoveNonExistingFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        boolean removal = shapeCollector.removeFigure(new Triangle(5, 3));
        Assert.assertFalse(removal);
    }

    @Test
    public void testGetFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape newFigure = new Triangle(5, 3);
        shapeCollector.addFigure(newFigure);
        Assert.assertEquals(newFigure, shapeCollector.getFigure(0));
    }

    @Test
    public void testShowFigures() {
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape newTriangle = new Triangle(5, 3);
        shapeCollector.addFigure(newTriangle);
        Shape newSquare = new Square(6.8);
        shapeCollector.addFigure(newSquare);
        Assert.assertEquals(shapeCollector.showFigures(), Arrays.asList(newTriangle, newSquare));
    }

    @Test
    public void testGetShapeName() {
        Shape newFigure = new Circle(3);
        Assert.assertEquals(newFigure.getShapeName(), "Circle");
    }

    @Test
    public void testGetField() {
        Shape square = new Square(8);
        Assert.assertEquals(square.getField(), 64);
    }
}
