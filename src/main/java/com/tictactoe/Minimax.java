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
            ArrayList<Integer> scores = new ArrayList<>();
            if (maximizingPlayersTurn) {
                calculateMinimaxScore(board, maximizingPlayersTurn, scores, this.selfSymbol);
                System.out.println("Maximizer: " + scores);
                return Collections.max(scores);
            }
            else {
                calculateMinimaxScore(board, maximizingPlayersTurn, scores, this.opponentSymbol);
                System.out.println("Minimizer: " + scores);
                return Collections.min(scores);
            }
        }
    }

    private void calculateMinimaxScore(Board board, boolean maximizingPlayersTurn, ArrayList<Integer> scores, String symbol) {
        for (int index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(board, index)) {
                board.insertSymbol(symbol, index);
                int score = this.minimax(board, !maximizingPlayersTurn);
                scores.add(score);
                board.resetCell(index);
            }
        }
    }

    private boolean isEmptyCell(Board board, int index) {
        return board.getSymbol(index).equals(" ");
    }
}
