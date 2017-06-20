package com.java.tictactoe;

public interface Rules {
    void identifyWinningCombos();

    boolean checkForWinner(Board board);
    boolean gameProgress(Board board);
    boolean endsInADraw();
    String getWinner();
}
