package com.tictactoe;

import java.util.ArrayList;
import java.util.Collections;

public class Grid {
    private Board board;
    private int boardSize;
    private int cellsPerRow;
    private final int CELL_OFFSET = 1;

    public Grid(Board board) {
        this.board = board;
        this.boardSize = board.getBoardSize();
        this.cellsPerRow = board.getCellsPerRow();
    }

    private int findMaxStringLengthOfSymbols() {
        String[] boardArray = this.board.getSymbol();
        ArrayList<Integer> symbolLength = new ArrayList<>();
        for (int i = 0; i < boardArray.length; i++) {
            symbolLength.add(boardArray[i].length());
        }
        return Collections.max(symbolLength);
    }

    private String getCenteredSymbols(String symbol, Integer maxLength) {
        if (symbol.length() == maxLength) {
            return symbol;
        } else {
            int paddingOnBothSides = maxLength - symbol.length();
            if (paddingOnBothSides % 2 == 0) {
                String padding = getPaddingSpace(paddingOnBothSides);
                return padding + symbol + padding;
            } else {
                String paddingLeft = getPaddingSpace(paddingOnBothSides);
                String paddingRight = paddingLeft + " ";
                return paddingLeft + symbol + paddingRight;
            }
        }
    }

    private String getPaddingSpace (int paddingOnBothSides) {
        String unit = "";
        int paddingOnEachSide = paddingOnBothSides / 2;
        for (int j = 0; j < paddingOnEachSide; j++) {
            unit += " ";
        }
        return unit;
    }

    public void draw() {
        System.out.println(getGrid());
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
        int maxLengthOfSymbols = this.findMaxStringLengthOfSymbols();
        row.append(this.insertRowsOfUpperVerticalPadding());
        for (int cellIndex = startingCell; cellIndex < startingCell + cellsPerRow; cellIndex++) {
              String lastCellCharacter = (cellIndex % cellsPerRow == this.cellsPerRow - CELL_OFFSET)? " " : " |";
              row.append(" " + this.getCenteredSymbols(board.getSymbol(cellIndex), maxLengthOfSymbols) + lastCellCharacter);
        }
        row.append(this.insertRowsOfLowerVerticalPadding());
        return row.toString();
    }

    private String drawRowDivider() {
        String horizontalLine = "\n";
        for (int i = 0; i < this.cellsPerRow; i++) {
            horizontalLine += this.drawingDividerOrPaddingUnit("-");
            horizontalLine += " ";
        }
        horizontalLine += "\n";
        return horizontalLine;
    }

    private String drawTopVerticalPadding() {
        String space = "";
        for (int i = 0; i < this.cellsPerRow; i++) {
            space += this.drawingDividerOrPaddingUnit(" ");
            if (i != this.cellsPerRow - 1) {
                space += "|";
            }
        }
        space += "\n";
        return space;
    }

    private String drawBottomVerticalPadding() {
        String space = "\n";
        for (int i = 0; i < this.cellsPerRow; i++) {
            space += this.drawingDividerOrPaddingUnit(" ");
            if (i != this.cellsPerRow - 1) {
                space += "|";
            }
        }
        return space;
    }

    private String insertRowsOfUpperVerticalPadding(){
        StringBuilder rowOfPadding = new StringBuilder ("");
        int rowsOfPadding = this.numberOfUpperVerticalRowOfPadding();
        for (int i = 0; i < rowsOfPadding; i++) {
            rowOfPadding.append(this.drawTopVerticalPadding());
        }
        return rowOfPadding.toString();
    }

    private String insertRowsOfLowerVerticalPadding(){
        StringBuilder rowOfPadding = new StringBuilder ("");
        int rowsOfPadding = this.numberOfLowerVerticalRowOfPadding();
        for (int i = 0; i < rowsOfPadding; i++) {
            rowOfPadding.append(this.drawBottomVerticalPadding());
        }
        return rowOfPadding.toString();
    }

    private int numberOfTotalVerticalRowPadding() {
        int maxLengthOfSymbols = this.findMaxStringLengthOfSymbols();
        int WIDTH_TO_HEIGHT_RELATIVE_CONVERSION_UNIT = 3;
        return maxLengthOfSymbols/WIDTH_TO_HEIGHT_RELATIVE_CONVERSION_UNIT;
    }

    private int numberOfUpperVerticalRowOfPadding() {
        return this.numberOfTotalVerticalRowPadding()/2;
    }

    private int numberOfLowerVerticalRowOfPadding() {
        int halfOfTotal = this.numberOfTotalVerticalRowPadding()/2;
        int oddOrEven = this.numberOfTotalVerticalRowPadding() % 2;
        int numberOfLowerPaddingRows = (oddOrEven == 0)? halfOfTotal : (halfOfTotal+1);
        return numberOfLowerPaddingRows;
    }

    private String drawingDividerOrPaddingUnit(String pattern) {
        String unit = "";
        int paddedSpaceCharacterOnBothEndsOfSymbols = 2;
        int maxLengthOfSymbols = this.findMaxStringLengthOfSymbols();
        for (int j = 0; j < maxLengthOfSymbols + paddedSpaceCharacterOnBothEndsOfSymbols; j++) {
            unit += pattern;
        }
        return unit;
    }

    public void drawGridWithOnlyCellNumberId(int maxLengthOfId) {
        System.out.println(getGridWithOnlyCellNumberId(maxLengthOfId));
    }

    public String getGridWithOnlyCellNumberId(int maxLengthOfId) {
        StringBuilder grid = new StringBuilder ("");
        for (int cellIndex = 0; cellIndex <= this.boardSize - this.cellsPerRow; cellIndex += this.cellsPerRow){
            grid.append(drawARowWithCellId(cellIndex, maxLengthOfId));
            if (cellIndex < this.boardSize - this.cellsPerRow) {
                grid.append(drawRowDividerForIdNumberGrid(maxLengthOfId));
            }
        }
        grid.append("\n");
        return grid.toString();
    }

    private String drawRowDividerForIdNumberGrid(int maxLengthOfId) {
        String horizontalLine = "\n";
        for (int i = 0; i < this.cellsPerRow; i++) {
            horizontalLine += this.drawingDividerForIdNumberGrid(maxLengthOfId);
            horizontalLine += " ";
        }
        horizontalLine += "\n";
        return horizontalLine;
    }

    private String drawingDividerForIdNumberGrid(int maxLengthOfId) {
        String unit = "";
        int paddedSpaceCharacterOnBothEndsOfSymbols = 2;
        for (int j = 0; j < maxLengthOfId + paddedSpaceCharacterOnBothEndsOfSymbols; j++) {
            unit += "-";
        }
        return unit;
    }

    private String drawARowWithCellId(int startingCell, int maxLengthOfId) {
        StringBuilder row = new StringBuilder ("");
        for (int i = startingCell; i < startingCell + cellsPerRow; i++) {
            String lastCellCharacter = (i % cellsPerRow == this.cellsPerRow - CELL_OFFSET)? " " : " |";
            row.append(" " + this.getCenteredSymbols(Integer.toString(i+CELL_OFFSET), maxLengthOfId) + lastCellCharacter);
        }
        return row.toString();
    }
}
