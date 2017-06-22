package com.tictactoe;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private UserInput simulateHumanPlayerCellSelection (String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        UserInput receiver = new UserInput(scanner);
        return receiver;
    }

    @Test
    public void testGameInProgress() throws Exception {
        UserInput receiver1 = simulateHumanPlayerCellSelection("3");
        HumanPlayer player1 = new HumanPlayer("X", receiver1);
        UserInput receiver2 = simulateHumanPlayerCellSelection("5");
        HumanPlayer player2 = new HumanPlayer("O", receiver2);
        Game game = new Game(player1, player2);
        game.makeMoveAndRenderMove(player1);
        game.makeMoveAndRenderMove(player2);
        assertTrue(game.gameInPlay());
    }
}
