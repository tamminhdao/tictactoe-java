package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EasyComputerPlayerTest {
    Board board;
    EasyComputerPlayer simpleAI;
    @Before
    public void setUp() {
        board = new Board();
        populateBoard(4);
        simpleAI = new EasyComputerPlayer("X", board);
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
    public void easyComputerPlayerTakesFirstAvailableSpotOnBoard() throws Exception {
        int cell = simpleAI.obtainValidCellSelection();
        assertEquals(4, cell);
    }
}
