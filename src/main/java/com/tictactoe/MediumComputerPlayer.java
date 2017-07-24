package com.tictactoe;
import java.util.*;

public class MediumComputerPlayer implements Player, SmartAI {
    private Board board;
    private String selfSymbol;
    private String opponentSymbol;
    private Rules rules;

    public MediumComputerPlayer(Board board) {
        this.board = board;
    }

    @Override
    public void addRules(Rules rules) {
        this.rules = rules;
    }

    @Override
    public void addSymbol(String symbol) {
        this.selfSymbol = symbol;
    }

    @Override
    public void addOpponentSymbol(String opponentSymbol) {
        this.opponentSymbol = opponentSymbol;
    }

    @Override
    public String getSymbol() {
        return this.selfSymbol;
    }

    @Override
    public int obtainValidCellSelection() {
        int CELL_OFFSET = 1;
        HashMap<Integer, Integer> scoreAndCell = new HashMap<>();
        for (int index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(board, index)) {
                board.insertSymbol(selfSymbol, index);
                int score = scoreEachCell(board);
                scoreAndCell.put(score, index);
                board.resetCell(index);
            }
        }
        Set allKeys = scoreAndCell.keySet();
        ArrayList<Integer> listOfKeys = new ArrayList<>(allKeys);
        int maxScore = Collections.max(listOfKeys);
        int cell = scoreAndCell.get(maxScore);
        return cell + CELL_OFFSET;
    }

    private boolean thereIsAWinner() {
        String winner = this.rules.checkForWinner(this.board);
        return !winner.equals("");
    }

    private boolean isEmptyCell(Board board, int index) {
        return board.getSymbol(index).equals(" ");
    }

    private int getWinOrLoseScore() {
        String winner = this.rules.checkForWinner(this.board);
        if (winner.equals(selfSymbol)) {
            return 1;
        }
        return -1;
    }

    public int scoreEachCell(Board board) {
        if (thereIsAWinner()) {
            return getWinOrLoseScore();
        }
        return 0;
    }
}
