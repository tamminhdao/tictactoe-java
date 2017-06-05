package apprenticeship;

import java.util.Arrays;

public class Board {
    private char cells[];
    private int numberOfCells = 9;

    public Board() {
        this.cells = new char [numberOfCells];
    }

    public int countCells() {
        return this.cells.length;
    }

    public char[] getSymbol() {
        return this.cells;
    }

    public char getSymbol (int index) {
        return this.cells[index];
    }

    public void insertSymbol(char symbol, int index) {
        this.cells[index] = symbol;
    }

    public String turnArrayToString(char[] array) {
        return Arrays.toString(array);
    }

    public void printBoard() {
        System.out.println(turnArrayToString(this.cells));


public class Board {
    private String[] cells = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public String getGrid() {
        return (" " + this.cells[0] + " | " + this.cells[1] + " | " + this.cells[2] + "\n--- --- ---\n" +
                " " + this.cells[3] + " | " + this.cells[4] + " | " + this.cells[5] + "\n--- --- ---\n" +
                " " + this.cells[6] + " | " + this.cells[7] + " | " + this.cells[8] + "\n");
    }

    public void drawGrid() {
        System.out.println(getGrid());

    }
}
