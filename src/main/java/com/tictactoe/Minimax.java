package com.tictactoe;

import java.util.ArrayList;
import java.util.Collections;

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

    private int getWinOrLoseScore(int depth) {
        if (rules.checkForWinner(board).equals(selfSymbol)) {
            return 10 - depth;
        }
        return -10 + depth;
    }

    private boolean thereIsAWinner() {
        String winner = this.rules.checkForWinner(this.board);
        return !winner.equals("");
    }

    private boolean isADraw() {
        return this.rules.endsInADraw(this.board);
    }

    public int minimax(Board board, boolean maximizingPlayersTurn, int depth) {
        depth += 1;

        if (thereIsAWinner()) {
            return getWinOrLoseScore(depth);
        } else if (isADraw()) {
            return 0;
        } else {
            ArrayList<Integer> scores = new ArrayList<>();
            String selfOrOpponent = maximizingPlayersTurn ? this.selfSymbol : this.opponentSymbol;

            for (int index = 0; index < board.getBoardSize(); index++) {
                if (isEmptyCell(board, index)) {
                    board.insertSymbol(selfOrOpponent, index);
                    int score = this.minimax(board, !maximizingPlayersTurn, depth);
                    scores.add(score);
                    board.resetCell(index);
                }
            }
            int minOrMaxScore = maximizingPlayersTurn ? Collections.max(scores) : Collections.min(scores);
            return minOrMaxScore;
        }
    }

    private boolean isEmptyCell(Board board, int index) {
        return board.getSymbol(index).equals(" ");
    }
}
