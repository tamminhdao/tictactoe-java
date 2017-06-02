package apprenticeship;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class BoardTest {
    private Board tictactoe;

    @Before
    public void initBoard() {
        tictactoe = new Board();
    }

    @Test
    public void aBoardInitializeWithNineCells() throws Exception {
        int emptyCells = tictactoe.countCells();
        assertEquals(emptyCells, 9);
    }

    @Test
    public void canInsertSymbolOnBoard() throws Exception {
        tictactoe.insertSymbol('x', 0);
        assertEquals(tictactoe.cells[0], 'x');
    }

    @Test
    public void canConvertEmptyBoardToString() throws Exception {
        String actual = tictactoe.turnBoardToString(tictactoe.cells);
        char[] testCells = new char [9];
        assertEquals(actual, Arrays.toString(testCells));
    }

    @Test
    public void canConvertNonEmptyBoardToString() throws Exception {
        tictactoe.insertSymbol('x', 0);
        tictactoe.insertSymbol('o', 1);
        tictactoe.insertSymbol('x', 2);
        tictactoe.insertSymbol('o', 3);
        tictactoe.insertSymbol('x', 4);
        tictactoe.insertSymbol('o', 5);
        tictactoe.insertSymbol('x', 6);
        tictactoe.insertSymbol('o', 7);
        tictactoe.insertSymbol('x', 8);
        String actual = tictactoe.turnBoardToString(tictactoe.cells);

        char[] expected = new char[] {'x', 'o', 'x', 'o', 'x', 'o', 'x', 'o', 'x'};

        assertEquals(actual, Arrays.toString(expected));

    }
}
