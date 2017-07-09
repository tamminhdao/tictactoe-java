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

    private int getWinLoseScore() {
        if (rules.getWinner().equals(AIplayer.getSymbol())) {
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

    //minimax function return the max score (from computer's pt of view) for a given board
    public int minimax() {
        int score = 0;
        if (this.thereIsAWinner()) {
            score = this.getWinLoseScore();
        } else if (this.isADraw()) {
            score = 0;
        }
        return score;
    }
}

