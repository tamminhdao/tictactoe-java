package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimaxTest {
    private void populateBoardScenario0(Board board) {
        board.insertSymbol("O", 0);
        board.insertSymbol("O", 7);
        board.insertSymbol("O", 8);
        board.insertSymbol("X", 2);
        board.insertSymbol("X", 3);
        board.insertSymbol("X", 6);
    }

    private void populateBoardScenario1(Board board, int numberOfCells) {
        for (int i = 0; i < numberOfCells; i++) {
            if (i % 2 == 0) {
                board.insertSymbol("X", i);
            } else {
                board.insertSymbol("O", i);
            }
        }
    }

    private void populateBoardScenario2(Board board, int numberOfCells) {
        for (int i = 0; i < numberOfCells; i++) {
            if (i % 2 == 0) {
                board.insertSymbol("O", i);
            } else {
                board.insertSymbol("X", i);
            }
        }
    }

    @Test
    public void canReturnCorrectScoreOf0IfGameStillInProgress() throws Exception {
        Board board = new Board();
        populateBoardScenario0(board);
        Rules rules = new RulesFor3x3();
        Player smartAI = new UnbeatableComputerPlayer("X", board);
        Minimax minimax = new Minimax(rules, board, smartAI);
        int score = minimax.getWinLoseOrTieScore();
        assertEquals(0, score);
    }

    @Test
    public void canReturnWinOrLoseScoreWhenXWins() throws Exception {
        Board board = new Board();
        populateBoardScenario1(board, 7);
        Rules rules = new RulesFor3x3();
        Player smartAI = new UnbeatableComputerPlayer("X", board);
        Minimax minimax = new Minimax(rules, board, smartAI);
        int score = minimax.getWinLoseOrTieScore();
        assertEquals(10, score);
    }

    @Test
    public void canReturnWinOrLoseScoreWhenOWins() throws Exception {
        Board board = new Board();
        populateBoardScenario2(board, 7);
        Rules rules = new RulesFor3x3();
        Player smartAI = new UnbeatableComputerPlayer("X", board);
        Minimax minimax = new Minimax(rules, board, smartAI);
        int score = minimax.getWinLoseOrTieScore();
        assertEquals(-10, score);
    }
}
