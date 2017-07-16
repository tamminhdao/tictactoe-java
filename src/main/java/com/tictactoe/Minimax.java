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
            return 10;
        }
        return -10;
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
        System.out.println("Depth " + depth);

        if (this.thereIsAWinner()) {
            System.out.println("There is a win");
            System.out.println("Depth " + depth);
            board.printBoard();
            System.out.println(this.getWinOrLoseScore(depth));
            return this.getWinOrLoseScore(depth);
        } else if (this.isADraw()) {
            System.out.println("There is a draw");
            System.out.println("Depth " + depth);
            board.printBoard();
            return 0;
        } else {
            ArrayList<Integer> scores = new ArrayList<>();
            if (maximizingPlayersTurn) {
                System.out.println("Simulating AI's move");
                for (int index = 0; index < board.getBoardSize(); index++) {
                    if (isEmptyCell(board, index)) {
                        board.insertSymbol(this.selfSymbol, index);
                            board.printBoard();
                        int score = this.minimax(board, !maximizingPlayersTurn, depth);
                        scores.add(score);
                        board.resetCell(index);
                            System.out.println(scores + "after AI's turn \n");
                    }
                }
                return Collections.max(scores);
            } else {
                System.out.println("Simulating human's move");
                for (int index = 0; index < board.getBoardSize(); index++) {
                    if (isEmptyCell(board, index)) {
                        board.insertSymbol(this.opponentSymbol, index);
                            board.printBoard();
                        int score = this.minimax(board, !maximizingPlayersTurn, depth);
                        scores.add(score);
                        board.resetCell(index);
                            System.out.println(scores + "after human's turn \n");
                    }
                }
                return Collections.min(scores);
            }
        }
    }

    private boolean isEmptyCell(Board board, int index) {
        return board.getSymbol(index).equals(" ");
    }
}
