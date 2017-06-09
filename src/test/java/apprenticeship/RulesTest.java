package apprenticeship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RulesTest {
    Board tictactoe;
    Rules gameRules;

    @Before
    public void createRules() {
        gameRules = new Rules();
        tictactoe = new Board(9);
    }

    @Test
    public void gameStartsOutWithNoWinner() throws Exception {
        boolean hasWinner = gameRules.checkForWinner();
        assertFalse(hasWinner);
    }

    private void populateBoard(int numberOfCells) {
        for (int i = 0; i < numberOfCells; i++) {
            if (i % 2 == 0) {
                tictactoe.insertSymbol("X", i);
            } else {
                tictactoe.insertSymbol("O", i);
            }
        }
    }

    @Test
    public void gameInProgressIfThereAreEmptyCellsAndNoWinner() throws Exception {
        populateBoard(5);
        boolean gameInProgress = gameRules.gameProgress(tictactoe);
        assertTrue(gameInProgress);
    }


    @Test
    public void gameEndsIfThereIsNoMoreEmptyCells() throws Exception {
        populateBoard(9);
        boolean gameInProgress = gameRules.gameProgress(tictactoe);
        assertFalse(gameInProgress);
    }

    @Test
    public void winningByRow() throws Exception {
        for (int i = 0; i < 3; i++) {
            tictactoe.insertSymbol("X", i);
        }
        boolean hasWinner = gameRules.checkForRowWin(tictactoe);

        assertTrue(hasWinner);
    }

    @Test
    public void verifyRowWinner() throws Exception {
        for (int i = 0; i < 3; i++) {
            tictactoe.insertSymbol("X", i);
        }
        gameRules.checkForRowWin(tictactoe);
        String winner = "X";
        assertEquals(winner, gameRules.getWinner());
    }

    @Test
    public void winningByColumn() throws Exception {
        for (int i = 0; i < 7; i += 3) {
            tictactoe.insertSymbol("O", i);
        }
        boolean hasWinner = gameRules.checkForColumnWin(tictactoe);

        assertTrue(hasWinner);
    }

    @Test
    public void verifyColumnWinner() throws Exception {
        for (int i = 0; i < 7; i += 3) {
            tictactoe.insertSymbol("O", i);
        }
        gameRules.checkForColumnWin(tictactoe);
        String winner = "O";
        assertEquals(winner, gameRules.getWinner());
    }

    @Test
    public void winningBy_0_4_8_Diagonal() throws Exception {
        for (int i = 0; i < 9; i += 4) {
            tictactoe.insertSymbol("X", i);
        }
        boolean hasWinner = gameRules.checkForDiagonalWin(tictactoe);

        assertTrue(hasWinner);
    }

    @Test
    public void winningBy_2_4_6_Diagonal() throws Exception {
        for (int i = 2; i < 7; i += 2) {
            tictactoe.insertSymbol("O", i);
        }
        boolean hasWinner = gameRules.checkForDiagonalWin(tictactoe);

        assertTrue(hasWinner);
    }
}
