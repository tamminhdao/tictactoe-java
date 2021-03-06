package com.tictactoe;
import java.util.*;

public class UnbeatableComputerPlayer implements Player {
    private Board board;
    private String selfSymbol;
    private String opponentSymbol;
    private Rules rules;

    public UnbeatableComputerPlayer(Board board) {
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
        testAndScoreEveryEmptyCell(scoreAndCell);
        int cell = pickCellWithTheHighestScore(scoreAndCell);
        return cell + CELL_OFFSET;
    }

    private int pickCellWithTheHighestScore(HashMap<Integer, Integer> scoreAndCell) {
        Set allKeys = scoreAndCell.keySet();
        ArrayList<Integer> listOfKeys = new ArrayList<>(allKeys);
        int maxScore = Collections.max(listOfKeys);
        return scoreAndCell.get(maxScore);
    }

    private void testAndScoreEveryEmptyCell(HashMap<Integer, Integer> scoreAndCell) {
        for (int index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(board, index)) {
                board.insertSymbol(selfSymbol, index);
                Minimax algorithm = new Minimax(this.rules, this.board, this.selfSymbol, this.opponentSymbol);
                int score = algorithm.scoreACell(board, false, 0);
                scoreAndCell.put(score, index);
                board.resetCell(index);
            }
        }
    }

    private boolean isEmptyCell(Board board, int index) {
        return board.getSymbol(index).equals(" ");
    }
}
