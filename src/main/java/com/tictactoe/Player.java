package com.tictactoe;

public interface Player {
    String getSymbol();
    int obtainValidCellSelection();
    void addBoard(Board board);
    void addSymbol(String symbol);
}
