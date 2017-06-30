package com.tictactoe;

import org.apache.commons.lang.StringUtils;
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
            return StringUtils.center(symbol, maxLength);
        }
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
//        row.append("              |              |              " + "\n");
//        row.append("              |              |              " + "\n");
        row.append("     |     |     " + "\n");
        for (int cellIndex = startingCell; cellIndex < startingCell + cellsPerRow; cellIndex++) {
              String lastCellCharacter = (cellIndex % cellsPerRow == this.cellsPerRow - CELL_OFFSET)? " " : " |";
              row.append(" " + this.getCenteredSymbols(board.getSymbol(cellIndex), maxLengthOfSymbols) + lastCellCharacter);
        }
//        row.append("\n" + "              |              |              ");
//        row.append("\n" + "              |              |              ");
        //row.append("\n" + "     |     |     ");
        return row.toString();
    }

    private String drawRowDivider() {
        String horizontalLine = "\n";
        for (int i = 0; i < this.cellsPerRow; i++) {
            horizontalLine += this.drawingDividerUnit("-");
            horizontalLine += " ";
        }
        horizontalLine += "\n";
        return horizontalLine;
    }
    //change to private
    public String drawTopVerticalPadding() {
        String space = "";
        for (int i = 0; i < this.cellsPerRow; i++) {
            space += this.drawingDividerUnit(" ");
            if (i != this.cellsPerRow - 1) {
                space += "|";
            }
        }
        space += "\n";
        return space;
    }
    //should be private
    public String drawBottomVerticalPadding() {
        String space = "\n";
        for (int i = 0; i < this.cellsPerRow; i++) {
            space += this.drawingDividerUnit(" ");
            if (i != this.cellsPerRow - 1) {
                space += "|";
            }
        }
        return space;
    }

    private String drawingDividerUnit(String pattern) {
        String unit = "";
        int paddedSpaceCharacterOnBothEndsOfSymbols = 2;
        int maxLengthOfSymbols = this.findMaxStringLengthOfSymbols();
        for (int j = 0; j < maxLengthOfSymbols + paddedSpaceCharacterOnBothEndsOfSymbols; j++) {
            unit += pattern;
        }
        return unit;
    }

    public void drawGridWithOnlyCellNumberId() {
        System.out.println(getGridWithOnlyCellNumberId());
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

    private String drawARowWithCellId(int startingCell) {
        StringBuilder row = new StringBuilder ("");
        int maxLengthOfSymbols = this.findMaxStringLengthOfSymbols();
        for (int i = startingCell; i < startingCell + cellsPerRow; i++) {
            String lastCellCharacter = (i % cellsPerRow == this.cellsPerRow - CELL_OFFSET)? " " : " |";
            row.append(" " + this.getCenteredSymbols(Integer.toString(i+CELL_OFFSET), maxLengthOfSymbols) + lastCellCharacter);
        }
        return row.toString();
    }
}
