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

    private void populateAnotherBoard(Board board) {
        board.insertSymbol("O", 0);
        board.insertSymbol("X", 4);
    }

    @Test
    public void easyComputerPlayerTakesFirstCellOnEmptyBoard() throws Exception {
        Board board = new Board();
        EasyComputerPlayer simpleAI = new EasyComputerPlayer("X", board);
        int cell = simpleAI.obtainValidCellSelection();
        assertEquals(1, cell);
    }

    @Test
    public void easyComputerPlayerTakesFirstAvailableSpotOnBoard_Case1() throws Exception {
        Board board = new Board();
        this.populateBoard(board,4);
        EasyComputerPlayer simpleAI = new EasyComputerPlayer("X", board);
        int cell = simpleAI.obtainValidCellSelection();
        assertEquals(5, cell);
    }

    @Test
    public void easyComputerPlayerTakesFirstAvailableSpotOnBoard_Case2() throws Exception {
        Board board = new Board();
        this.populateAnotherBoard(board);
        EasyComputerPlayer simpleAI = new EasyComputerPlayer("X", board);
        int cell = simpleAI.obtainValidCellSelection();
        assertEquals(2, cell);
    }

    @Test
    public void testFullBoard() throws Exception {
        Board board = new Board();
        this.populateBoard(board,9);
        EasyComputerPlayer simpleAI = new EasyComputerPlayer("X", board);
        int cell = simpleAI.obtainValidCellSelection();
        assertEquals(10, cell);
    }
}
