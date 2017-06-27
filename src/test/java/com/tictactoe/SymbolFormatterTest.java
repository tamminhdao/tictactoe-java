package com.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SymbolFormatterTest {

    @Test
    public void transformSymbolsIntoTwoStringOfEqualLength() {
        SymbolFormatter formatter = new SymbolFormatter("O", "XXX");
        String newPlayer1Symbol = formatter.formatSymbol(formatter.getPlayer1Symbol());
        String newPlayer2Symbol = formatter.formatSymbol(formatter.getPlayer2Symbol());
        formatter.setPlayer1Symbol(newPlayer1Symbol);
        formatter.setPlayer2Symbol(newPlayer2Symbol);
        assertEquals("O  ", formatter.getPlayer1Symbol());
        assertEquals("XXX", formatter.getPlayer2Symbol());
    }

    @Test
    public void symbolDoesNotChangeIfOriginalLengthAreEqual() {
        SymbolFormatter formatter = new SymbolFormatter("XSP", "XXL");
        String newPlayer1Symbol = formatter.formatSymbol(formatter.getPlayer1Symbol());
        String newPlayer2Symbol = formatter.formatSymbol(formatter.getPlayer2Symbol());
        formatter.setPlayer1Symbol(newPlayer1Symbol);
        formatter.setPlayer2Symbol(newPlayer2Symbol);
        assertEquals("XSP", formatter.getPlayer1Symbol());
        assertEquals("XXL", formatter.getPlayer2Symbol());
    }
}
