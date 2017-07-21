package com.tictactoe;

import org.junit.Before;
import org.junit.Test;

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

    @Test
    public void computerNeverLosesIfHumanGoesFirst() throws Exception {
        //boolean smartAILoses = false;
        UnbeatableComputerPlayer smartAI = new UnbeatableComputerPlayer(rules, board, "AI", "O");
        for (int index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(board, index)) {
                board.insertSymbol("O", index);
                makeMove(board, smartAI);
                board.resetCell(index);
            }
        }
    }

    private void makeMove (Board board, UnbeatableComputerPlayer smartAI) {
        for (int index = 0; index < board.getBoardSize(); index++) {
            if (!gameInPlay()) {
                board.populateBoardWithEmptyCells();
                int c = counter + 1;
                board.insertSymbol("O", c);
                System.out.println(c);
                makeMove(board, smartAI, c);
            } else {
                if (isEmptyCell(board, index)) {
                    board.insertSymbol("O", index);
                    //board.printBoard();
                    if (board.countEmptyCells() != 0) {
                        int computerSelection = smartAI.obtainValidCellSelection();
                        board.insertSymbol("AI", computerSelection - CELL_OFFSET);
                        //board.printBoard();
                    }
                    makeMove(board, smartAI, 0);
                }
            }
        }
    }

    public boolean gameInPlay() {
        boolean hasNoWinner = this.rules.checkForWinner(board).equals("");
        boolean isNotADraw = !this.rules.endsInADraw(this.board);
        return (hasNoWinner && isNotADraw);
    }

    private boolean isEmptyCell(Board board, int index) {
        return board.getSymbol(index).equals(" ");
    }
}