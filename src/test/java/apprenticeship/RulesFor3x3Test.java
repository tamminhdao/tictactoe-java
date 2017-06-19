package apprenticeship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class RulesFor3x3Test {
    Board tictactoe;
    RulesFor3x3 gameRulesFor3x3;

    @Before
    public void createRules() {
        gameRulesFor3x3 = new RulesFor3x3();
        tictactoe = new Board(9);
    }

    @Test
    public void gameStartsOutWithNoWinner() throws Exception {
        boolean hasWinner = gameRulesFor3x3.checkForWinner(tictactoe);
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
        boolean gameInProgress = gameRulesFor3x3.gameProgress(tictactoe);
        assertTrue(gameInProgress);
    }


    @Test
    public void gameEndsIfThereIsNoMoreEmptyCells() throws Exception {
        populateBoard(9);
        boolean gameInProgress = gameRulesFor3x3.gameProgress(tictactoe);
        assertFalse(gameInProgress);
    }

    @Test
    public void gameEndsIfThereIsAWinner() throws Exception {
        for (int i = 3; i < 6; i++) {
            tictactoe.insertSymbol("X", i);
        }
        gameRulesFor3x3.checkForWinner(tictactoe);
        boolean gameInProgress = gameRulesFor3x3.gameProgress(tictactoe);
        assertFalse(gameInProgress);
    }

    @Test
    public void winningByRow() throws Exception {
        for (int i = 0; i < 3; i++) {
            tictactoe.insertSymbol("X", i);
        }
        boolean hasWinner = gameRulesFor3x3.checkForWinner(tictactoe);
        assertTrue(hasWinner);
    }

    @Test
    public void verifyRowWinner() throws Exception {
        for (int i = 0; i < 3; i++) {
            tictactoe.insertSymbol("X", i);
        }
        gameRulesFor3x3.checkForWinner(tictactoe);
        String winner = "X";
        assertEquals(winner, gameRulesFor3x3.getWinner());
    }

    @Test
    public void winningByColumn() throws Exception {
        for (int i = 0; i < 7; i += 3) {
            tictactoe.insertSymbol("O", i);
        }
        boolean hasWinner = gameRulesFor3x3.checkForWinner(tictactoe);
        assertTrue(hasWinner);
    }

    @Test
    public void verifyColumnWinner() throws Exception {
        for (int i = 0; i < 7; i += 3) {
            tictactoe.insertSymbol("O", i);
        }
        gameRulesFor3x3.checkForWinner(tictactoe);
        String winner = "O";
        assertEquals(winner, gameRulesFor3x3.getWinner());
    }

    @Test
    public void winningByDiagonalTopLeftToBottomRight() throws Exception {
        for (int i = 0; i < 9; i += 4) {
            tictactoe.insertSymbol("X", i);
        }
        boolean hasWinner = gameRulesFor3x3.checkForWinner(tictactoe);
        assertTrue(hasWinner);
    }

    @Test
    public void winningByDiagonalTopRightToBottomLeft() throws Exception {
        for (int i = 2; i < 7; i += 2) {
            tictactoe.insertSymbol("O", i);
        }
        boolean hasWinner = gameRulesFor3x3.checkForWinner(tictactoe);
        assertTrue(hasWinner);
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
        gameRulesFor3x3.gameProgress(tictactoe);
        gameRulesFor3x3.checkForWinner(tictactoe);
        assertTrue(gameRulesFor3x3.endsInADraw());
    }

    @Test
    public void gameEndsWhenThereIsATie() throws Exception {
        simulateAGameWhichEndsInATie();
        boolean gameInProgress = gameRulesFor3x3.gameProgress(tictactoe);
        assertFalse(gameInProgress);
    }
}
