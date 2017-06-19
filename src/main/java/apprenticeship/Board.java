package apprenticeship;

import java.util.Arrays;

public class Board {
    private final int boardSize;
    private String[] cells;
    private int cellsPerRow;


    public Board() {
        this.boardSize = 9;
        this.cellsPerRow = 3;
        this.cells = new String[9];
        this.populateBoardWithEmptyCells();
    }

    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cellsPerRow = (int) Math.sqrt(this.boardSize);
        this.cells = new String[this.boardSize];
        this.populateBoardWithEmptyCells();
    }

    private void populateBoardWithEmptyCells() {
        String emptyCell = " ";
        for (int i = 0; i < this.cells.length; i++) {
            this.cells[i] = emptyCell;
        }
    }

    public int countEmptyCells() {
        int numberOfEmptyCells = 0;
        for (int i = 0; i < this.cells.length; i++) {
            if (this.cells[i] == " ") {
                numberOfEmptyCells += 1;
            }
        }
        return numberOfEmptyCells;
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
        StringBuilder grid = new StringBuilder ("");
        for (int cellIndex = 0; cellIndex <= this.boardSize - this.cellsPerRow; cellIndex += this.cellsPerRow){
            grid.append(drawARow(cellIndex));
            grid.append(drawRowDivider());
        }
        return grid.toString();
    }

    private String drawARow(int startingCell) {
        StringBuilder row = new StringBuilder ("");
        for (int cellIndex = startingCell; cellIndex < startingCell + cellsPerRow; cellIndex++) {
            row.append("  " + cells[cellIndex] + "  |");
        }
        return row.toString();
    }

    private String drawRowDivider() {
        String horizontalLine = "\n";
        for (int i = 0; i < this.cellsPerRow; i++) {
            horizontalLine += "----- ";
        }
        horizontalLine += "\n";
        return horizontalLine;
    }

    public void drawGrid() {
        System.out.println(getGrid());
    }

    public void populateBoardWithOnlyCellNumberId() {
        String[] idList = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        for (int i = 0; i < idList.length; i++) {
            this.cells[i] = idList[i];
        }
    }

    public void drawGridWithOnlyCellNumberId() {
        populateBoardWithOnlyCellNumberId();
        System.out.println (getGrid());
        populateBoardWithEmptyCells();
    }
}
