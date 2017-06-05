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
    }
}
