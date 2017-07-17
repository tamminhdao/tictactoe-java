package com.tictactoe;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

public class GameSettingsTest {

    private UserInput simulateUserInput (String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        return new UserInput(scanner);
    }

    @Test
    public void canSetPlayerSymbol() throws Exception {
        Board board = new Board();
        UserInputValidator validator = new UserInputValidator(board);
        UserInput receiver = simulateUserInput("abc");
        GameSettings settings = new GameSettings(receiver, validator, board);
        String testPlayersSymbol = settings.chooseSymbol("Test Player");
        assertEquals("abc", testPlayersSymbol);
    }

    @Test
    public void canSelectPlayerType() throws Exception {
        Board board = new Board();
        UserInputValidator validator = new UserInputValidator(board);
        UserInput receiver = simulateUserInput("C");
        GameSettings settings = new GameSettings(receiver, validator, board);
        Player testPlayers = settings.pickPlayerType("Test Player");
        Player easyLevelAI = new EasyComputerPlayer(board);
        assertEquals(testPlayers.getClass(), easyLevelAI.getClass());
    }
}