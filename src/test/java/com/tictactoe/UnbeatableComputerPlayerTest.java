package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnbeatableComputerPlayerTest {
    @Test
    public void canBlockAWin() throws Exception {
        Board board = new Board();
        int CELL_OFFSET = 1;
        board.insertSymbol("O", 2);
        board.insertSymbol("O", 4);
        board.insertSymbol("AI", 8);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        int cellIndex = cell - CELL_OFFSET;
        assertEquals(6, cellIndex);
    }

    @Test
    public void strategizeAWinningMove() throws Exception {
        Board board = new Board();
        int CELL_OFFSET = 1;
        board.insertSymbol("O", 6);
        board.insertSymbol("O", 8);
        board.insertSymbol("AI", 7);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        int cellIndex = cell - CELL_OFFSET;
        assertEquals(4, cellIndex);
    }

    @Test
    public void takeCenterCell() throws Exception {
        Board board = new Board();
        int CELL_OFFSET = 1;
        board.insertSymbol("O", 0);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        int cellIndex = cell - CELL_OFFSET;
        assertEquals(4, cellIndex);
    }
}