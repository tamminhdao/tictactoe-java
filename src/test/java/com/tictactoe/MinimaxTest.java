package com.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MinimaxTest {

    private void populateBoard_X_Wins(Board board) {
        for (int i = 0; i < 7; i++) {
            if (i % 2 == 0) {
                board.insertSymbol("X", i);
            } else {
                board.insertSymbol("O", i);
            }
        }
    }

    private void populateBoard_O_Wins(Board board) {
        for (int i = 0; i < 7; i++) {
            if (i % 2 == 0) {
                board.insertSymbol("O", i);
            } else {
                board.insertSymbol("X", i);
            }
        }
    }

    private void populateBoard_GameEndsInATie(Board board) {
        board.insertSymbol("X", 0);
        board.insertSymbol("X", 1);
        board.insertSymbol("O", 2);
        board.insertSymbol("O", 3);
        board.insertSymbol("O", 4);
        board.insertSymbol("X", 5);
        board.insertSymbol("X", 6);
        board.insertSymbol("O", 7);
        board.insertSymbol("X", 8);
    }

    private void populateBoard(Board board) {
        board.insertSymbol("X", 0);
        board.insertSymbol("X", 7);
        board.insertSymbol("X", 8);
    }

    @Test
    public void canReturnWinOrLoseScoreWhenXWins() throws Exception {
        Board board = new Board();
        populateBoard_X_Wins(board);
        Rules rules = new RulesFor3x3();
        Minimax minimax = new Minimax(rules, board, "X", "O");
        int score = minimax.minimax(board, true);
        assertEquals(10, score);
    }

    @Test
    public void canReturnWinOrLoseScoreWhenOWins() throws Exception {
        Board board = new Board();
        populateBoard_O_Wins(board);
        Rules rules = new RulesFor3x3();
        Minimax minimax = new Minimax(rules, board, "X", "O");
        int score = minimax.minimax(board, true);
        assertEquals(-10, score);
    }

    @Test
    public void canReturnCorrectScoreIfGameEndsInATie() throws Exception {
        Board board = new Board();
        populateBoard_GameEndsInATie(board);
        Rules rules = new RulesFor3x3();
        Minimax minimax = new Minimax(rules, board, "X", "O");
        int score = minimax.minimax(board, true);
        assertEquals(0, score);
    }
}
