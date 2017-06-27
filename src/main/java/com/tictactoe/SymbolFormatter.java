package com.tictactoe;

public class SymbolFormatter {
    private String player1Symbol;
    private String player2Symbol;

    public SymbolFormatter (String player1Symbol, String player2Symbol) {
        this.player1Symbol = player1Symbol;
        this.player2Symbol = player2Symbol;
    }

    public String getPlayer1Symbol() {
        return this.player1Symbol;
    }

    public String getPlayer2Symbol() {
        return this.player2Symbol;
    }

    public void setPlayer1Symbol(String newSymbol) {
        this.player1Symbol = newSymbol;
    }

    public void setPlayer2Symbol(String newSymbol) {
        this.player2Symbol = newSymbol;
    }

    public String formatSymbol(String symbol) {
        int differenceWithMaxLength = calculateLengthDifference(symbol);
        String buffer = createEmptySpaceBufferForSymbol(differenceWithMaxLength);
        symbol = symbol + buffer;
        return symbol;
    }

    private int identifyLengthOfLongerString() {
        int len1 = player1Symbol.length();
        int len2 = player2Symbol.length();
        return Math.max(len1, len2);
    }

    private int calculateLengthDifference(String symbol) {
        int maxLength = this.identifyLengthOfLongerString();
        int lengthDifference = maxLength - symbol.length();
        return lengthDifference;
    }

    private String createEmptySpaceBufferForSymbol(int lengthDifference) {
        String buffer = "";
        for (int i = 0; i < lengthDifference; i++) {
            buffer += " ";
        }
        return buffer;
    }
}
