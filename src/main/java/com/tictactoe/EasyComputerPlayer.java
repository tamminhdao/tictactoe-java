package com.tictactoe;

public class EasyComputerPlayer implements Player {
    private Board board;
    private String symbol;
    private String opponentSymbol;
    private Rules rules;

    public EasyComputerPlayer(Board board) {
        this.board = board;
    }

    @Override
    public void addRules(Rules rules) {
        this.rules = rules;
    }

    @Override
    public void addSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public void addOpponentSymbol(String opponentSymbol) {
        this.opponentSymbol = opponentSymbol;
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
