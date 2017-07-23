package com.tictactoe;

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

    public void populateBoardWithEmptyCells() {
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

    public int getBoardSize() {
        return this.boardSize;
    }

    public int getCellsPerRow() {
        return this.cellsPerRow;
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
}
