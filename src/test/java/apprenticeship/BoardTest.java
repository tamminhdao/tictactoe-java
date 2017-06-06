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
        tictactoe.insertSymbol("X", 0);
        String atZero = tictactoe.getSymbol(0);
        assertEquals(atZero, "X");
    }

//    @Test
//    public void canConvertEmptyBoardToString() throws Exception {
//        String[] allSymbolsOnBoard = tictactoe.getSymbol();
//        String actual = tictactoe.turnArrayToString(allSymbolsOnBoard);
//
//        String[] testCells = new String [9];
//        assertEquals(actual, Arrays.toString(testCells));
//    }

    @Test
    public void canConvertNonEmptyBoardToString() throws Exception {
        tictactoe.insertSymbol("X", 0);
        tictactoe.insertSymbol("O", 1);
        tictactoe.insertSymbol("X", 2);
        tictactoe.insertSymbol("O", 3);
        tictactoe.insertSymbol("X", 4);
        tictactoe.insertSymbol("O", 5);
        tictactoe.insertSymbol("X", 6);
        tictactoe.insertSymbol("O",7);
        tictactoe.insertSymbol("X", 8);
        String[] actual = tictactoe.getSymbol();

        String[] expected = new String[] {"X", "O", "X", "O", "X", "O", "X", "O", "X"};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void drawGrid() {
        tictactoe.drawGrid();
    }
}
