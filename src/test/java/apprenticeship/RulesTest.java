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
        tictactoe = new Board();
        tictactoe.clearBoard();
    }

    @Test
    public void gameStartsOutWithNoWinner() throws Exception {
        boolean hasWinner = gameRules.hasWinner();
        assertFalse(hasWinner);
    }

    @Test
    public void gameStartsOutWithAllEmptyCellsOnBoard() throws Exception {
        int numberOfEmptyCells = gameRules.countEmptyCells();
        int totalNumberOfCells = tictactoe.countCells();
        assertEquals(numberOfEmptyCells, totalNumberOfCells);
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
        boolean hasWinner = gameRules.hasWinner();
        assertTrue(hasWinner);
    }
}
