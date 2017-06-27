package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GridTest {
    private Board board;
    Grid tictactoe;

    @Before
    public void initBoard() {
        board = new Board();
        tictactoe = new Grid(board);
    }

    @Test
    public void canRenderGridWithAllEmptyCells() throws Exception {
        String newGrid = tictactoe.getGrid();

        String expected =   "     |     |     " + "\n----- ----- ----- \n" +
                            "     |     |     " + "\n----- ----- ----- \n" +
                            "     |     |     " + "\n";

        assertEquals (newGrid, expected);
    }

    private void populateBoard(int numberOfCells) {
        for (int i = 0; i < numberOfCells; i++) {
            if (i % 2 == 0) {
                board.insertSymbol("X", i);
            } else {
                board.insertSymbol("O", i);
            }
        }
    }

    @Test
    public void canRenderGridWithSymbolsInserted() throws Exception {
        populateBoard(4);
        String newGrid = tictactoe.getGrid();

        String expected =   "  X  |  O  |  X  " + "\n----- ----- ----- \n" +
                            "  O  |     |     " + "\n----- ----- ----- \n" +
                            "     |     |     " + "\n";

        assertEquals (newGrid, expected);
    }

    @Test
    public void canRenderGridWithOnlyCellNumberId() throws Exception {
        String newGrid = tictactoe.getGridWithOnlyCellNumberId();


        String expected =   "  1  |  2  |  3  " + "\n----- ----- ----- \n" +
                            "  4  |  5  |  6  " + "\n----- ----- ----- \n" +
                            "  7  |  8  |  9  " + "\n";

        assertEquals (newGrid, expected);
    }
}