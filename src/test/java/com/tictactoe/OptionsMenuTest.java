package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsMenuTest {
    @Test
    public void menuCanCreateAGame() throws Exception {
        MockGame testGame = new MockGame();
        OptionsMenu startMenu = new OptionsMenu(testGame);
        startMenu.open();
        assertEquals(true, testGame.addedPlayerOne);
        assertEquals(true, testGame.addedPlayerTwo);
        assertEquals(true, testGame.hasAddedABoard);
        assertEquals(true, testGame.hasBeenPlayed);
    }
}