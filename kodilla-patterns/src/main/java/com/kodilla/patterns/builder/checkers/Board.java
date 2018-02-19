package com.kodilla.patterns.builder.checkers;

public class Board {
    public static final int MIN_INDEX = 0;
    public static final int MAX_INDEX = 9;
    Figure[][] board = new Figure[10][];

    /**
     * Submodule 11.5. Create board.
     */
    public Board() {
        for (int n = 0; n < 10; n++) {
            board[n] = new Figure[10];
        }
    }

    public Figure getFigure(final int x, final int y) {
        return board[x][y];
    }

    public void setFigure(final Figure figure, final int x, final int y) {
        board[x][y] = figure;
    }

    /**
     * Submodule 11.5. toString().
     * @return String
     */
    public String toString() {
        String result = "";
        for (int n = MIN_INDEX; n <= MAX_INDEX; n++) {
            result += "|";
            for (int k = MIN_INDEX; k <= MAX_INDEX; k++) {
                if (board[n][k] == null) {
                    result += "  ";
                } else {
                    result += (board[n][k]).getColor().equals(Figure.BLACK) ? "b" : "w";
                    result += (board[n][k]) instanceof Pawn ? "P" : "Q";
                }
                result += "|";
            }
            result += "\n";
        }
        return result;
    }
}
