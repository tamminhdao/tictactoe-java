package com.java.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BoardTest {
    private Board tictactoe;

    @Before
    public void initBoard() {
        tictactoe = new Board();
    }

    @Test
    public void canInsertSymbolOnBoard() throws Exception {
        tictactoe.insertSymbol("X", 0);
        String atZero = tictactoe.getSymbol(0);
        assertEquals(atZero, "X");
    }

    @Test
    public void canConvertEmptyBoardToString() throws Exception {
        String[] actual = tictactoe.getSymbol();
        String[] expected = new String[9];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = " ";
        }
        assertArrayEquals(actual, expected);
    }

    private void populateBoard(int numberOfCells) {
        for (int i = 0; i < numberOfCells; i++) {
            if (i % 2 == 0) {
                tictactoe.insertSymbol("X", i);
            } else {
                tictactoe.insertSymbol("O", i);
            }
        }
    }

    @Test
    public void canConvertNonEmptyBoardToString() throws Exception {
        populateBoard(9);
        String[] actual = tictactoe.getSymbol();

        String[] expected = new String[] {"X", "O", "X", "O", "X", "O", "X", "O", "X"};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void canPopulateBoardWithOnlyCellNumberId() throws Exception {
        tictactoe.populateBoardWithOnlyCellNumberId();
        String[] actual = tictactoe.getSymbol();

        String[] expected = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        assertArrayEquals (actual, expected);
    }

    @Test
    public void canRenderGridWithAllEmptyCells() throws Exception {
        String newGrid = tictactoe.getGrid();

        String expected =   "     |     |     |" + "\n----- ----- ----- \n" +
                            "     |     |     |" + "\n----- ----- ----- \n" +
                            "     |     |     |" + "\n----- ----- ----- \n";

        assertEquals (newGrid, expected);
    }

    @Test
    public void canRenderGridWithSymbolsInserted() throws Exception {
        populateBoard(4);
        String newGrid = tictactoe.getGrid();

        String expected =   "  X  |  O  |  X  |" + "\n----- ----- ----- \n" +
                            "  O  |     |     |" + "\n----- ----- ----- \n" +
                            "     |     |     |" + "\n----- ----- ----- \n";

        assertEquals (newGrid, expected);
    }

    @Test
    public void canRenderGridWithOnlyCellNumberId() throws Exception {
        tictactoe.populateBoardWithOnlyCellNumberId();
        String newGrid = tictactoe.getGrid();


        String expected =   "  1  |  2  |  3  |" + "\n----- ----- ----- \n" +
                            "  4  |  5  |  6  |" + "\n----- ----- ----- \n" +
                            "  7  |  8  |  9  |" + "\n----- ----- ----- \n";

        assertEquals (newGrid, expected);
    }
}
