package com.tictactoe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MediumComputerPlayerTest {
    private final int CELL_OFFSET = 1;
    private Board board;
    private Rules rules;
    private MediumComputerPlayer mediumAI;
    @Before
    public void initElements() {
        board = new Board();
        rules = new RulesFor3x3();
        mediumAI = new MediumComputerPlayer(board);
        mediumAI.addRules(rules);
        mediumAI.addSymbol("AI");
        mediumAI.addOpponentSymbol("O");
    }

    @Test
    public void mediumLevelPlayerCanBlockAWin() throws Exception {
        board.insertSymbol("O", 1);
        board.insertSymbol("O", 4);
        int cellSelection = mediumAI.obtainValidCellSelection();
        int cellIndex = cellSelection - CELL_OFFSET;
        assertEquals(7, cellIndex);
    }

    @Test
    public void mediumLevelPlayerCanTakeAWin() throws Exception {
        board.insertSymbol("O", 0);
        board.insertSymbol("O", 1);
        board.insertSymbol("AI", 2);
        board.insertSymbol("AI", 4);
        int cellSelection = mediumAI.obtainValidCellSelection();
        int cellIndex = cellSelection - CELL_OFFSET;
        assertEquals(6, cellIndex);
    }

    @Test
    public void winAndBlockAtTheSameCell() throws Exception {
        board.insertSymbol("O", 2);
        board.insertSymbol("O", 4);
        board.insertSymbol("AI", 0);
        board.insertSymbol("AI", 3);
        int cellSelection = mediumAI.obtainValidCellSelection();
        int cellIndex = cellSelection - CELL_OFFSET;
        assertEquals(6, cellIndex);
    }

    @Test
    public void makeRandomMoveIfThereIsNoBlockNorWinToTake() throws Exception {
        board.insertSymbol("O", 2);
        board.insertSymbol("AI", 3);
        int cellSelection = mediumAI.obtainValidCellSelection();
        int cellIndex = cellSelection - CELL_OFFSET;
        assertEquals(6, cellIndex);
    }
}
