package com.tictactoe;

public class Grid {
    Board board;
    int boardSize;
    int cellsPerRow;
    int cellWidth;
    String player1Symbol;
    String player2Symbol;

    public Grid(Board board, String player1Symbol, String player2Symbol) {
        this.board = board;
        this.boardSize = board.getBoardSize();
        this.cellsPerRow = board.getCellsPerRow();
        this.player1Symbol = player1Symbol;
        this.player2Symbol = player2Symbol;
        this.cellWidth = Math.max(player1Symbol.length(), player2Symbol.length());
    }

    public String getGrid() {
        StringBuilder grid = new StringBuilder ("");
        for (int cellIndex = 0; cellIndex <= this.boardSize - this.cellsPerRow; cellIndex += this.cellsPerRow){
            grid.append(drawARow(cellIndex));
            if (cellIndex < this.boardSize - this.cellsPerRow) {
                grid.append(drawRowDivider());
            }
        }
        grid.append("\n");
        return grid.toString();
    }

    private String drawARow(int startingCell) {
        StringBuilder row = new StringBuilder ("");
        for (int cellIndex = startingCell; cellIndex < startingCell + cellsPerRow; cellIndex++) {
            if (cellIndex % cellsPerRow == this.cellsPerRow - 1) {
                row.append(" " + board.getSymbol(cellIndex) + " ");
            } else {
                row.append(" " + board.getSymbol(cellIndex) + " " + "|");
            }
        }
        return row.toString();
    }

    private String drawRowDivider() {
        String horizontalLine = "\n";
        for (int i = 0; i < this.cellsPerRow; i++) {
            horizontalLine += this.drawingDivider();
            horizontalLine += " ";
        }
        horizontalLine += "\n";
        return horizontalLine;
    }

    private String drawingDivider() {
        String unit = "";
        for (int j = 0; j < this.cellWidth + 2; j++) {
            unit += "-";
        }
        return unit;
    }

    private String drawSymbolPadding() {
        String unit = "";
        for (int j = 0; j < this.cellWidth; j++) {
            unit += " ";
        }
        return unit;
    }

    public void drawGrid() {
        System.out.println(getGrid());
    }


    private String drawARowWithCellId(int startingCell) {
        StringBuilder row = new StringBuilder ("");
        for (int i = startingCell; i < startingCell + cellsPerRow; i++) {
            if (i % cellsPerRow == this.cellsPerRow - 1) {
                row.append(this.drawSymbolPadding() + (i+1) + " ");
            } else {
                row.append(this.drawSymbolPadding() + (i+1) + " |");
            }
        }
        return row.toString();
    }

    public String getGridWithOnlyCellNumberId() {
        StringBuilder grid = new StringBuilder ("");
        for (int cellIndex = 0; cellIndex <= this.boardSize - this.cellsPerRow; cellIndex += this.cellsPerRow){
            grid.append(drawARowWithCellId(cellIndex));
            if (cellIndex < this.boardSize - this.cellsPerRow) {
                grid.append(drawRowDivider());
            }
        }
        grid.append("\n");
        return grid.toString();
    }

    public void drawGridWithOnlyCellNumberId() {
        System.out.println(getGridWithOnlyCellNumberId());
    }
}
