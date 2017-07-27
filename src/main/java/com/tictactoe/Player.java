package com.tictactoe;

public interface Player {
    String getSymbol();
    int obtainValidCellSelection();
    void addSymbol(String symbol);
    void addOpponentSymbol(String opponentSymbol);
    void addRules(Rules rules);
}