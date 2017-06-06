package apprenticeship;

import java.util.Arrays;

public class Board {
    private String[] cells = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private StringBuilder row = new StringBuilder ("");
    //private StringBuilder grid = new StringBuilder ("");
    private String grid = "";
    private int boardDimension = 3;

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
        for (int cellIndex = 0; cellIndex <= this.cells.length - this.boardDimension; cellIndex += this.boardDimension){
            //this.grid.append(drawARow(cellIndex));
            //this.grid.append(drawTheDivider());
            this.grid = drawARow(cellIndex);
            //this.grid += drawTheDivider();
        }
//        String boardGrid = this.grid.toString();
//        return boardGrid;
        return this.grid;
    }

    public String drawARow(int startingCell) {
        for (int cellIndex = startingCell; cellIndex < startingCell + boardDimension; cellIndex++) {
            this.row.append(" " + cells[cellIndex] + " |");
        }
        //this.row.append("\n--- --- ---\n");
        this.row.append(drawTheDivider());

        String aRow = this.row.toString();
        return aRow;
    }

    public String drawTheDivider() {
        String divider = "\n";
        for (int i = 0; i < this.boardDimension; i++) {
            divider += "--- ";
        }
        divider += "\n";
        return divider;
    }

    public void drawGrid() {
        System.out.println(getGrid());
    }
}
