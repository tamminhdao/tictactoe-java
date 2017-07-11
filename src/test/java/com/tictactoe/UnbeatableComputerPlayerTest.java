package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnbeatableComputerPlayerTest {
    private void populateBoardWhereXTakesCell4ToWin(Board board) {
        board.insertSymbol("O", 0);
        board.insertSymbol("X", 2);
        board.insertSymbol("X", 3);
        board.insertSymbol("O", 5);
        board.insertSymbol("X", 6);
        board.insertSymbol("O", 7);
        board.insertSymbol("O", 8);
    }

    @Test
    public void unbeatablePlayer() throws Exception {
        Board board = new Board();
        populateBoardWhereXTakesCell4ToWin(board);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(board, "X", "O");
        int cell = smartAI.obtainValidCellSelection();
        board.printBoard();
        assertEquals(5, cell);
    }

    @Test
    public void blocking() throws Exception {
        Board board = new Board();
        board.insertSymbol("O", 2);
        board.insertSymbol("O", 4);
        board.insertSymbol("AI", 8);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        board.printBoard();
        assertEquals(7, cell);
    }
}