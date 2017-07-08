package com.tictactoe;

public class UnbeatableComputerPlayer implements Player{
    Board board;
    String symbol;

    public UnbeatableComputerPlayer(String symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
    }

    @Override
    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public int obtainValidCellSelection() {
        return 1;
    }
}
