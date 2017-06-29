package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EasyComputerPlayerTest {

    private void populateBoard(Board board, int numberOfCells) {
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
        Board board = new Board();
        this.populateBoard(board,4);
        EasyComputerPlayer simpleAI = new EasyComputerPlayer("X", board);
        int cell = simpleAI.obtainValidCellSelection();
        assertEquals(5, cell);
    }
}
