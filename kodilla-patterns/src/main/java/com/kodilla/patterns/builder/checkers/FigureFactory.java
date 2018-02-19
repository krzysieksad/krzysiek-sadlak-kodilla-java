package com.kodilla.patterns.builder.checkers;

public class FigureFactory {
    public static final String PAWN = "PAWN";
    public static final String QUEEN = "QUEEN";

    /**
     * Submodule 11.5. Creating checkers figures.
     * @param figureType type
     * @param color color
     * @return figure
     */
    public static Figure makeFigure(final String figureType, final String color) {
        if (figureType.equals(PAWN)) {
            return new Pawn(color);
        } else if (figureType.equals(QUEEN)) {
            return new Queen(color);
        } else {
            throw new IllegalStateException("Type of figure should be pawn or queen");
        }
    }
}
