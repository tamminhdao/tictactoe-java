package com.tictactoe;

public class EasyComputerPlayer implements Player {
    Board board;
    String symbol;

    public EasyComputerPlayer(String symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public int obtainValidCellSelection() {
        int index;
        for (index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(index))
                break;
        }
        return index;
    }

    private boolean isEmptyCell(int index) {
        return board.getSymbol(index).equals(" ");
    }
}
