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
        lookForAWinOrABlock(scoreAndCell, selfSymbol);
        lookForAWinOrABlock(scoreAndCell, opponentSymbol);
        Set allKeys = scoreAndCell.keySet();
        ArrayList<Integer> listOfKeys = new ArrayList<>(allKeys);
        if (listOfKeys.size() != 0) {
            int maxScore = Collections.max(listOfKeys);
            int cell = scoreAndCell.get(maxScore);
            return cell + CELL_OFFSET;
        } else {
            
        }
    }

    private void lookForAWinOrABlock(HashMap<Integer, Integer> scoreAndCell, String symbol) {
        for (int index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(board, index)) {
                System.out.println("Insert at: " + index);
                board.insertSymbol(symbol, index);
                int score = scoreEachCell();
                System.out.println("Score: " + score);
                if (score != 0) {
                    scoreAndCell.put(score, index);
                }
                board.resetCell(index);
            }
        }
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

    public int scoreEachCell() {
        if (thereIsAWinner()) {
            return getWinOrLoseScore();
        }
        return 0;
    }
}
