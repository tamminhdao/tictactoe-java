package com.tictactoe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RulesFor3x3Test {
    private Board tictactoe;
    private RulesFor3x3 gameRulesFor3x3;

    @Before
    public void createRules() {
        gameRulesFor3x3 = new RulesFor3x3();
        tictactoe = new Board(9);
    }

    @Test
    public void winningByRow() throws Exception {
        for (int i = 0; i < 3; i++) {
            tictactoe.insertSymbol("X", i);
        }
        String winner = gameRulesFor3x3.checkForWinner(tictactoe);
        assertEquals("X", winner);
    }

    @Test
    public void winningByColumn() throws Exception {
        for (int i = 0; i < 7; i += 3) {
            tictactoe.insertSymbol("O", i);
        }
        String winner = gameRulesFor3x3.checkForWinner(tictactoe);
        assertEquals("O", winner);
    }

    @Test
    public void winningByDiagonalTopLeftToBottomRight() throws Exception {
        for (int i = 0; i < 9; i += 4) {
            tictactoe.insertSymbol("X", i);
        }
        String winner = gameRulesFor3x3.checkForWinner(tictactoe);
        assertEquals("X", winner);
    }

    @Test
    public void winningByDiagonalTopRightToBottomLeft() throws Exception {
        for (int i = 2; i < 7; i += 2) {
            tictactoe.insertSymbol("O", i);
        }
        String winner = gameRulesFor3x3.checkForWinner(tictactoe);
        assertEquals("O", winner);
    }

    private void simulateAGameWhichEndsInATie() {
        tictactoe.insertSymbol("X", 0);
        tictactoe.insertSymbol("O", 1);
        tictactoe.insertSymbol("X", 2);
        tictactoe.insertSymbol("O", 3);
        tictactoe.insertSymbol("O", 4);
        tictactoe.insertSymbol("X", 5);
        tictactoe.insertSymbol("O", 6);
        tictactoe.insertSymbol("X", 7);
        tictactoe.insertSymbol("O", 8);
    }

    @Test
    public void gameTiesWhenThereIsNoWinAndNoMoreEmptyCells() throws Exception {
        simulateAGameWhichEndsInATie();
        boolean draw = gameRulesFor3x3.endsInADraw(tictactoe);
        assertTrue(draw);
    }
}
