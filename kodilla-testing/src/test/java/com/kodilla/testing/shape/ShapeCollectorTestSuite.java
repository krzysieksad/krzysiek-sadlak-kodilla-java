package com.kodilla.testing.shape;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ShapeCollectorTestSuite {
    @Test
    public void testAddFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        //when
        shapeCollector.addFigure(new Triangle(5, 3));
        //then
        Assert.assertEquals(shapeCollector.showFigures().size(), 1);
    }

    @Test
    public void testRemoveFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Triangle(5, 3));
        //when
        boolean removal = shapeCollector.removeFigure(new Triangle(5, 3));
        //then
        Assert.assertTrue(removal);
        Assert.assertEquals(shapeCollector.showFigures().size(), 0);
    }

    @Test
    public void testRemoveNonExistingFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        //when
        boolean removal = shapeCollector.removeFigure(new Triangle(5, 3));
        //then
        Assert.assertFalse(removal);
    }

    @Test
    public void testGetFigure() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape newFigure = new Triangle(5, 3);
        //when
        shapeCollector.addFigure(newFigure);
        //then
        Assert.assertEquals(newFigure, shapeCollector.getFigure(0));
    }

    @Test
    public void testShowFigures() {
        //given
        ShapeCollector shapeCollector = new ShapeCollector();
        Shape newTriangle = new Triangle(5, 3);
        shapeCollector.addFigure(newTriangle);
        Shape newSquare = new Square(6.8);
        shapeCollector.addFigure(newSquare);
        //when
        List<Shape> figures = shapeCollector.showFigures();
        //then
        Assert.assertEquals(figures, Arrays.asList(newTriangle, newSquare));
    }

    @Test
    public void testGetShapeName() {
        //given
        Shape newFigure = new Circle(3);
        //when
        String figureName = newFigure.getShapeName();
        //then
        Assert.assertEquals(figureName, "Circle");
    }

    @Test
    public void testGetField() {
        //given
        Shape square = new Square(8);
        //when
        double field = square.getField();
        //then
        Assert.assertEquals(field, 64, 0);
    }
}
