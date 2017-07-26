package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class UnbeatableComputerPlayerTest {
    private Board board;
    private Rules rules;
    private final int CELL_OFFSET = 1;

    @Before
    public void initBoardAndRules() {
        board = new Board();
        rules = new RulesFor3x3();
    }

    @Test
    public void canBlockAWin() throws Exception {
        board.insertSymbol("O", 2);
        board.insertSymbol("O", 4);
        board.insertSymbol("AI", 8);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(rules, board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        int cellIndex = cell - CELL_OFFSET;
        assertEquals(6, cellIndex);
    }

    @Test
    public void takeAWin() throws Exception {
        board.insertSymbol("O", 6);
        board.insertSymbol("O", 8);
        board.insertSymbol("AI", 4);
        board.insertSymbol("AI", 7);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(rules, board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        int cellIndex = cell - CELL_OFFSET;
        assertEquals(1, cellIndex);
    }

    @Test
    public void preventOpponentFromCreatingAFork() throws Exception {
        board.insertSymbol("O", 1);
        board.insertSymbol("O", 3);
        board.insertSymbol("O", 8);
        board.insertSymbol("AI", 4);
        board.insertSymbol("AI", 7);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(rules, board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        int cellIndex = cell - CELL_OFFSET;
        assertEquals(2, cellIndex);
    }

    @Test
    public void takeCenterCell() throws Exception {
        board.insertSymbol("O", 0);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(rules, board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        int cellIndex = cell - CELL_OFFSET;
        assertEquals(4, cellIndex);
    }

    @Test
    public void takeIntoAccountDepth() throws Exception {
        board.insertSymbol("O", 1);
        board.insertSymbol("O", 5);
        board.insertSymbol("O", 8);
        board.insertSymbol("AI", 6);
        board.insertSymbol("AI", 7);
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(rules, board, "AI", "O");
        int cell = smartAI.obtainValidCellSelection();
        int cellIndex = cell - CELL_OFFSET;
        assertEquals(2, cellIndex);
    }
}
