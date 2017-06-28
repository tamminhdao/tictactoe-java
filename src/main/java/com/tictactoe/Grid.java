package com.tictactoe;

import java.util.*;

public class Grid {
    Board board;
    int boardSize;
    int cellsPerRow;
    int cellWidth;

    public Grid(Board board) {
        this.board = board;
        this.boardSize = board.getBoardSize();
        this.cellsPerRow = board.getCellsPerRow();
    }

    public int findMaxStringLengthOfSymbols(Board board) {
        String[] boardArray = board.getSymbol();
        ArrayList<Integer> symbolLength = new ArrayList<>();
        for (int i = 0; i < boardArray.length; i++) {
            symbolLength.add(boardArray[i].length());
        }
        return Collections.max(symbolLength);
    }

    public String getPaddedSymbols(String symbol, Integer maxLength) {
        if (symbol.length() == maxLength) {
            return symbol;
        } else {
            int lengthDifference = maxLength - symbol.length();
            return this.padLeft(symbol, lengthDifference);
        }
    }

    private String padLeft(String symbol, int space) {
        space = space + 1;
        return String.format("%1$" + space + "s", symbol);
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
        int maxLengthOfSymbols = this.findMaxStringLengthOfSymbols(board);
        for (int cellIndex = startingCell; cellIndex < startingCell + cellsPerRow; cellIndex++) {
              String lastCellCharacter = (cellIndex % cellsPerRow == this.cellsPerRow - 1)? " " : " |";
              row.append(" " + this.getPaddedSymbols(board.getSymbol(cellIndex), maxLengthOfSymbols) + lastCellCharacter);
        }
        return row.toString();
    }

    private String drawRowDivider() {
        String horizontalLine = "\n";
        for (int i = 0; i < this.cellsPerRow; i++) {
            horizontalLine += this.drawingDividerUnit();
            horizontalLine += " ";
        }
        horizontalLine += "\n";
        return horizontalLine;
    }

    private String drawingDividerUnit() {
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

