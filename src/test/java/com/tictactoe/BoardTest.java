package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


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
}
