package apprenticeship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BoardTest {
    private Board tictactoe;

    @Before
    public void initBoard() {
        tictactoe = new Board();
    }


    @Test
    public void canInsertSymbolOnBoard() throws Exception {
        tictactoe.insertSymbol("X", 0);
        String atZero = tictactoe.getSymbol(0);
        assertEquals(atZero, "X");
    }

    @Test
    public void canConvertEmptyBoardToString() throws Exception {
        String[] actual = tictactoe.getSymbol();
        String[] expected = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void canConvertNonEmptyBoardToString() throws Exception {
        tictactoe.insertSymbol("X", 0);
        tictactoe.insertSymbol("O", 1);
        tictactoe.insertSymbol("X", 2);
        tictactoe.insertSymbol("O", 3);
        tictactoe.insertSymbol("X", 4);
        tictactoe.insertSymbol("O", 5);
        tictactoe.insertSymbol("X", 6);
        tictactoe.insertSymbol("O", 7);
        tictactoe.insertSymbol("X", 8);
        String[] actual = tictactoe.getSymbol();

        String[] expected = new String[] {"X", "O", "X", "O", "X", "O", "X", "O", "X"};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void canRenderGridWithOnlyCellNumberId() throws Exception {
        String emptyGrid = tictactoe.getGrid();

        String expected =   " " + "1 | 2 | 3" + "\n--- --- ---\n" +
                            " " + "4 | 5 | 6" + "\n--- --- ---\n" +
                            " " + "7 | 8 | 9" + "\n";

        assertEquals (emptyGrid, expected);
    }

    @Test
    public void canRenderGridWithSymbolsInserted() throws Exception {
        tictactoe.insertSymbol("X", 0);
        tictactoe.insertSymbol("O", 1);
        tictactoe.insertSymbol("X", 2);
        tictactoe.insertSymbol("O", 3);
        String newGrid = tictactoe.getGrid();

        String expected =   " " + "X | O | X" + "\n--- --- ---\n" +
                            " " + "O | 5 | 6" + "\n--- --- ---\n" +
                            " " + "7 | 8 | 9" + "\n";

        assertEquals (newGrid, expected);
    }

    @Test
    public void drawARow() {
        String aRow = tictactoe.drawARow(6);
        System.out.println(aRow);
    }

    @Test
    public void drawAGrid() {
        tictactoe.drawGrid();
    }

    @Test
    public void getGrid() throws Exception {
        String aGrid = tictactoe.getGrid();
        System.out.println(aGrid);
    }
}
