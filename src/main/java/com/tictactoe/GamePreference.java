package com.tictactoe;

public class GamePreference {
    public String player1Symbol;
    public String player2Symbol;

    public void formatSymbol() {
        int len1 = player1Symbol.length();
        int len2 = player2Symbol.length();
        if (len1 > len2) {
            int lenDiffer = len1 - len2;
            this.player2Symbol = player2Symbol + createEmptySpaceBufferForShorterSymbol(lenDiffer);
        } else {
            int lenDiffer = len2 - len1;
            this.player1Symbol = player1Symbol + createEmptySpaceBufferForShorterSymbol(lenDiffer);
        }
    }

    public String createEmptySpaceBufferForShorterSymbol(int length) {
        String buffer = "";
        for (int i = 0; i < length; i++) {
            buffer += " ";
        }
        return buffer;
    }
}
