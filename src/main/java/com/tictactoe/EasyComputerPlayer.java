package com.tictactoe;

public class EasyComputerPlayer implements Player {
    Board board;
    String symbol;

    public EasyComputerPlayer(Board board) {
        this.board = board;
    }

    public void addSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public int obtainValidCellSelection() {
        int index;
        int CELL_OFFSET = 1;
        for (index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(index))
                break;
        }
        return index + CELL_OFFSET;
    }

    private boolean isEmptyCell(int index) {
        return board.getSymbol(index).equals(" ");
    }
}
