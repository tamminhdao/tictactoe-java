package com.tictactoe;

public class Minimax {
    private Rules rules;
    private Board board;
    private Player AIplayer;

    public Minimax(Rules rules, Board board, Player AIplayer) {
        this.rules = rules;
        this.board = board;
        this.AIplayer = AIplayer;
    }

    public int getWinLoseOrTieScore() {
        if (this.thereIsAWinner()) {
            if (rules.getWinner().equals(AIplayer.getSymbol())) {
                return 10;
            } else if (!rules.getWinner().equals(AIplayer.getSymbol())) {
                return -10;
            }
        }
        return 0;
    }

    private boolean thereIsAWinner() {
        return this.rules.checkForWinner(this.board);
    }
}
