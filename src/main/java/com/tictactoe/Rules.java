package com.tictactoe;

public interface Rules {
    void identifyWinningCombos();

    String checkForWinner(Board board);
    boolean gameProgress(Board board);
    boolean endsInADraw(Board board);
}
