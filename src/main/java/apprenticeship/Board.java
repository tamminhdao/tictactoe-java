package apprenticeship;

import java.util.Arrays;

public class Board {
    private String[] cells = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private int numberOfCells = 9;

    public Board() {
        this.cells = new String [numberOfCells];
    }

    public int countCells() {
        return this.cells.length;
    }

    public String[] getSymbol() {
        return this.cells;
    }

    public String getSymbol (int index) {
        return this.cells[index];
    }

    public void insertSymbol(String symbol, int index) {
        this.cells[index] = symbol;
    }

    public String turnArrayToString(String[] array) {
        return Arrays.toString(array);
    }

    public void printBoard() {
        System.out.println(turnArrayToString(this.cells));
    }

    public String getGrid() {
        return (" " + this.cells[0] + " | " + this.cells[1] + " | " + this.cells[2] + "\n--- --- ---\n" +
                " " + this.cells[3] + " | " + this.cells[4] + " | " + this.cells[5] + "\n--- --- ---\n" +
                " " + this.cells[6] + " | " + this.cells[7] + " | " + this.cells[8] + "\n");
    }

    public void drawGrid() {
        System.out.println(getGrid());

    }
}
