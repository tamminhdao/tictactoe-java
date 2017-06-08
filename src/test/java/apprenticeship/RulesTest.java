package apprenticeship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class RulesTest {
    Board tictactoe;
    Rules gameRules;

    @Before
    public void createRules() {
        gameRules = new Rules();
        tictactoe = new Board();
    }

    @Test
    public void gameStartsOutWithNoWinner() throws Exception {
        boolean hasWinner = gameRules.hasWinner();
        assertFalse(hasWinner);
    }

//    @Test
//    public void gameStartsOutWithAllEmptyCellsOnBoard() throws Exception {
//        boolean numberOfEmptyCells = gameRules.countEmptyCells();
//        assertEquals(numberOfEmptyCells, tictactoe.length);
//    }

}
