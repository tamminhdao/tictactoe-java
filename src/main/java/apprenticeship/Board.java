package apprenticeship;

import java.util.Arrays;

public class Board {
    private int boardSize;
    private String[] cells;
    private StringBuilder grid = new StringBuilder ("");
    private int cellsPerRow;

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
        for (int cellIndex = 0; cellIndex <= this.boardSize - this.cellsPerRow; cellIndex += this.cellsPerRow){
            this.grid.append(drawARow(cellIndex));
            this.grid.append(drawRowDivider());
        }
        return this.grid.toString();
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
        String[] idList = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < idList.length; i++) {
            this.cells[i] = idList[i];
        }
    }

    public void drawGridWithOnlyCellNumberId() {
        populateBoardWithOnlyCellNumberId();
        System.out.println (getGrid());
    }
}
