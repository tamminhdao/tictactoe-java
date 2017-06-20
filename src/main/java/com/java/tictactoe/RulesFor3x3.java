package com.java.tictactoe;


public class RulesFor3x3 implements Rules {
    private boolean gameInProgress = true;
    private boolean hasWinner = false;
    private boolean isADraw = false;
    private String winner;

    private int[][] winningCombos;

    public RulesFor3x3() {
        this.identifyWinningCombos();
    }

    @Override
    public boolean gameProgress(Board board) {
        if (board.countEmptyCells() == 0) {
            this.gameInProgress = false;
        } else if (this.checkForWinner(board)) {
            this.gameInProgress = false;
        }
        return this.gameInProgress;
    }


    @Override
    public void identifyWinningCombos() {
        this.winningCombos = new int[][] {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    }


    @Override
    public boolean checkForWinner(Board board) {
        for (int index = 0; index < this.winningCombos.length; index++) {
            if (threeInARow(board, index)) {
                this.hasWinner = true;
                this.winner = board.getSymbol(this.winningCombos[index][0]);
                break;
            } else {
                this.hasWinner = false;
            }
        }
        return this.hasWinner;
    }

    private boolean threeInARow(Board board, int index) {
        return !(board.getSymbol(this.winningCombos[index][0]).equals(" ")) &&
                board.getSymbol(this.winningCombos[index][0]).equals(board.getSymbol(this.winningCombos[index][1])) &&
                board.getSymbol(this.winningCombos[index][1]).equals(board.getSymbol(this.winningCombos[index][2]));
    }

    @Override
    public boolean endsInADraw() {
        if (!hasWinner && !gameInProgress) {
            this.isADraw = true;
        }
        return isADraw;
    }

    @Override
    public String getWinner() {
        return this.winner;
    }
}
