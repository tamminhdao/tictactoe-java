package apprenticeship;

import java.util.Arrays;

public class Board {
    public char cells[];

    public Board() {
        this.cells = new char [9];
    }

    public int countCells() {
        return this.cells.length;
    }

    public void insertSymbol(char symbol, int index) {
        this.cells[index] = symbol;
    }

    public String turnBoardToString(char cells[]) {
        return Arrays.toString(cells);
    }

    public void printBoard() {
        System.out.println(turnBoardToString(this.cells));
    }

}
