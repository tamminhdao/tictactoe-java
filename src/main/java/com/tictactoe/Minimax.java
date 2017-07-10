package com.tictactoe;

public class Minimax {
    private Rules rules;
    private Board board;
    private String selfSymbol;
    private String opponentSymbol;

    public Minimax(Rules rules, Board board, String selfSymbol, String opponentSymbol) {
        this.rules = rules;
        this.board = board;
        this.selfSymbol = selfSymbol;
        this.opponentSymbol = opponentSymbol;
    }

    private int getWinOrLoseScore() {
        if (rules.getWinner().equals(selfSymbol)) {
            return 10;
        }
        return -10;
    }

    private boolean thereIsAWinner() {
        return this.rules.checkForWinner(this.board);
    }

    private boolean isADraw() {
        return this.rules.endsInADraw(this.board);
    }

    public int minimax(Board board, boolean maximizingPlayersTurn) {
        if (this.thereIsAWinner()) {
            return this.getWinOrLoseScore();
        } else if (this.isADraw()) {
            return 0;
        } else {
            if (maximizingPlayersTurn) {
                for (int index = 0; index < board.getBoardSize(); index++) {
                    if (isEmptyCell(board, index)) {
                        board.insertSymbol(selfSymbol, index);
                        return this.minimax(board, !maximizingPlayersTurn);
                    }
                }
            }
            else {
                for (int index = 0; index < board.getBoardSize(); index++) {
                    if (isEmptyCell(board, index)) {
                        board.insertSymbol(opponentSymbol, index);
                        return this.minimax(board, !maximizingPlayersTurn);
                    }
                }
            }
        }
        return 10000;
    }

    private boolean isEmptyCell(Board board, int index) {
        return board.getSymbol(index).equals(" ");
    }
}
