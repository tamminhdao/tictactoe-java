package com.tictactoe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MediumComputerPlayerTest {
    private final int CELL_OFFSET = 1;

    @Test
    public void mediumLevelPlayerCanBlockAWin() throws Exception {
        Board board = new Board();
        Rules rules = new RulesFor3x3();
        MediumComputerPlayer mediumAI = new MediumComputerPlayer(board);
        mediumAI.addRules(rules);
        mediumAI.addSymbol("AI");
        mediumAI.addOpponentSymbol("O");
        board.insertSymbol("O", 1);
        board.insertSymbol("O", 4);
        int cellSelection = mediumAI.obtainValidCellSelection();
        int cellIndex = cellSelection - CELL_OFFSET;
        assertEquals(7, cellIndex);
    }
}
