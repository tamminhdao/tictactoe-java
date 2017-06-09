package apprenticeship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class BoardTest {
    private Board tictactoe;

    @Before
    public void initBoard() {
        tictactoe = new Board(9);
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
        //String[] expected = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] expected = new String[9];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = " ";
        }
        assertArrayEquals(actual, expected);
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
    public void canConvertNonEmptyBoardToString() throws Exception {
        populateBoard(9);
        String[] actual = tictactoe.getSymbol();

        String[] expected = new String[] {"X", "O", "X", "O", "X", "O", "X", "O", "X"};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void canRenderGridWithOnlyCellNumberId() throws Exception {
        String emptyGrid = tictactoe.drawGridWithOnlyCellNumberId();

        String expected =   "  1  |  2  |  3  |" + "\n----- ----- ----- \n" +
                            "  4  |  5  |  6  |" + "\n----- ----- ----- \n" +
                            "  7  |  8  |  9  |" + "\n----- ----- ----- \n";

        assertEquals (emptyGrid, expected);
    }

    @Test
    public void canRenderGridWithSymbolsInserted() throws Exception {
        populateBoard(4);
        String newGrid = tictactoe.getGrid();

        String expected =   "  X  |  O  |  X  |" + "\n----- ----- ----- \n" +
                            "  O  |     |     |" + "\n----- ----- ----- \n" +
                            "     |     |     |" + "\n----- ----- ----- \n";

        assertEquals (newGrid, expected);
    }


    @Test
    public void boardStartsOutWithAllEmptyCells() throws Exception {
        int totalNumberOfCells = tictactoe.countCells();
        int numberOfEmptyCells = tictactoe.countEmptyCells();
        assertEquals(totalNumberOfCells, numberOfEmptyCells);
    }

    @Test
    public void drawGrid() throws Exception {
        tictactoe.drawGrid();
    }

    @Test
    public void drawGridWithId() throws Exception {
        String gridWithId = tictactoe.drawGridWithOnlyCellNumberId();
        System.out.println(gridWithId);

    }
}
