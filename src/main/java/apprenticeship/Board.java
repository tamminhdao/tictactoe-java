package apprenticeship;

import java.util.Arrays;

public class Board {
    private String[] cells = new String[9];
    private StringBuilder grid = new StringBuilder ("");
    private double boardDimension = Math.sqrt(this.cells.length);

    private void populateBoardWithEmptyCells() {
        String emptyCell = " ";
        for (int i = 0; i < this.cells.length; i++) {
            this.cells[i] = emptyCell;
        }
    }

    public void getNewBoard() {
        populateBoardWithEmptyCells();
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

    private void populateBoardWithOnlyCellNumberId() {
        String[] id = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
            for (int i = 0; i < id.length; i++) {
                this.cells[i] = id[i];
            }
    }

    public String drawGridWithOnlyCellNumberId() {
        populateBoardWithOnlyCellNumberId();
        return (getGrid());
    }

    public String getGrid() {
        for (int cellIndex = 0; cellIndex <= this.cells.length - this.boardDimension; cellIndex += this.boardDimension){
            this.grid.append(drawARow(cellIndex));
            this.grid.append(drawRowDivider());
        }
        return this.grid.toString();
    }

    private String drawARow(int startingCell) {
        StringBuilder row = new StringBuilder ("");
        for (int cellIndex = startingCell; cellIndex < startingCell + boardDimension; cellIndex++) {
            row.append("  " + cells[cellIndex] + "  |");
        }
        return row.toString();
    }

    private String drawRowDivider() {
        String horizontalLine = "\n";
        for (int i = 0; i < this.boardDimension; i++) {
            horizontalLine += "----- ";
        }
        horizontalLine += "\n";
        return horizontalLine;
    }

    public void drawGrid() {
        System.out.println(getGrid());
    }
}
