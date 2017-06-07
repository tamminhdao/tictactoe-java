package apprenticeship;

import java.util.Arrays;

public class Board {
    private String[] cells = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    private StringBuilder row = new StringBuilder ("");
    //private StringBuilder grid = new StringBuilder ("");
    private String grid = "";
    private double boardDimension = Math.sqrt(this.cells.length);

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
            
            this.grid = drawARow(cellIndex);
        }
//        String boardGrid = this.grid.toString();
//        return boardGrid;
        return this.grid;
    }

    private String drawARow(int startingCell) {
        for (int cellIndex = startingCell; cellIndex < startingCell + boardDimension; cellIndex++) {
            this.row.append(" " + cells[cellIndex] + " |");
        }
        
        this.row.append(drawRowDivider());
        
        return(this.row.toString());
    }

    private String drawRowDivider() {
        String horizontalLine = "\n";
        for (int i = 0; i < this.boardDimension; i++) {
            horizontalLine += "--- ";
        }
        horizontalLine += "\n";
        return horizontalLine;
    }

    public void drawGrid() {
        System.out.println(getGrid());
    }
}
