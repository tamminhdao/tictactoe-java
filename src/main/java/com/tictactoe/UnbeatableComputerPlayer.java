package com.tictactoe;

import java.util.*;

public class UnbeatableComputerPlayer implements Player {
    private Board board;
    private String selfSymbol;
    private String opponentSymbol;

    public UnbeatableComputerPlayer(Board board, String selfSymbol, String opponentSymbol) {
        this.selfSymbol = selfSymbol;
        this.opponentSymbol = opponentSymbol;
        this.board = board;
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
                System.out.println("Top level simulation: ");
                board.printBoard();
                Rules rules = new RulesFor3x3();
                Minimax algorithm = new Minimax(rules, board, this.selfSymbol, this.opponentSymbol);
                int score = algorithm.minimax(board, false, 0);
                scoreAndCell.put(score, index);
                System.out.println("Finish simulation");
                System.out.println("Current score " + score);
                System.out.println("Current cell " + index);
                board.resetCell(index);
            }
        }
        Set allKeys = scoreAndCell.keySet();
        ArrayList<Integer> listOfKeys = new ArrayList<>(allKeys);
        System.out.println("All scores " + Arrays.toString(listOfKeys.toArray()));
        int maxScore = Collections.max(listOfKeys);
        int cell = scoreAndCell.get(maxScore);
        return cell + CELL_OFFSET;
    }

    private boolean isEmptyCell(Board board, int index) {
        return board.getSymbol(index).equals(" ");
    }
}
