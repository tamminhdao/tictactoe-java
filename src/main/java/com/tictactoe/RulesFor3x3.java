package com.tictactoe;


public class RulesFor3x3 implements Rules {

    private int[][] winningCombos;

    public RulesFor3x3() {
        this.identifyWinningCombos();
    }


    @Override
    public void identifyWinningCombos() {
        this.winningCombos = new int[][] {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    }


    @Override
    public String checkForWinner(Board board) {
        for (int index = 0; index < this.winningCombos.length; index++) {
            if (threeInARow(board, index)) {
                return board.getSymbol(this.winningCombos[index][0]);
            }
        }
        return "";
    }

    private boolean threeInARow(Board board, int index) {
        return !(board.getSymbol(this.winningCombos[index][0]).equals(" ")) &&
                board.getSymbol(this.winningCombos[index][0]).equals(board.getSymbol(this.winningCombos[index][1])) &&
                board.getSymbol(this.winningCombos[index][1]).equals(board.getSymbol(this.winningCombos[index][2]));
    }

    @Override
    public boolean endsInADraw(Board board) {
        return (!checkForWinner(board).equals("") && board.countEmptyCells() == 0);
    }
}
