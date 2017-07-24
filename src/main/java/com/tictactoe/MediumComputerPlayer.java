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
        HashMap<Integer, Integer> scoreAndCellForWinningOrBlockingMoves = new HashMap<>();
        testPlayEveryCellWithBothSymbols(scoreAndCellForWinningOrBlockingMoves);
        Set allKeys = scoreAndCellForWinningOrBlockingMoves.keySet();
        ArrayList<Integer> listOfKeys = new ArrayList<>(allKeys);
        if (listOfKeys.size() != 0) {
            int cell = pickCellWithTheHighestScore(scoreAndCellForWinningOrBlockingMoves, listOfKeys);
            return cell + CELL_OFFSET;
        } else {
            int randomCell = getARandomCell();
            return randomCell + CELL_OFFSET;

        }
    }

    private int getARandomCell() {
        ArrayList<Integer> availableCells = getAllEmptyCells(board);
        System.out.println("All empty cells: " + availableCells);
        Random r = new Random();
        int randomIndex = r.nextInt(availableCells.size());
        System.out.println("random index number: " + randomIndex);
        System.out.println("picked cell: " + availableCells.get(randomIndex));
        return availableCells.get(randomIndex);
    }

    private ArrayList<Integer> getAllEmptyCells(Board board) {
        ArrayList<Integer> availableCells = new ArrayList<>();
        for (int index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(board, index)) {
                availableCells.add(index);
            }
        }
        return availableCells;
    }

    private int pickCellWithTheHighestScore(HashMap<Integer, Integer> scoreAndCell, ArrayList<Integer> listOfKeys) {
        int maxScore = Collections.max(listOfKeys);
        return scoreAndCell.get(maxScore);
    }

    private void testPlayEveryCellWithBothSymbols(HashMap<Integer, Integer> scoreAndCell) {
        lookForAWinOrABlock(scoreAndCell, selfSymbol);
        lookForAWinOrABlock(scoreAndCell, opponentSymbol);
    }

    private void lookForAWinOrABlock(HashMap<Integer, Integer> scoreAndCell, String symbol) {
        for (int index = 0; index < board.getBoardSize(); index++) {
            if (isEmptyCell(board, index)) {
                board.insertSymbol(symbol, index);
                int score = scoreEachCell();
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

    private int scoreEachCell() {
        if (thereIsAWinner()) {
            return getWinOrLoseScore();
        }
        return 0;
    }
}
