package com.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void playAFullGameWithTwoEasyComputerPlayers() throws Exception {
        Board board = new Board();
        Player player1 = new EasyComputerPlayer("X", board);
        Player player2 = new EasyComputerPlayer("O", board);
        Game game = new Game(player1, player2, board);
        game.play();
        String[] boardCells = board.getSymbol();
        String[] expected = {"X","O","X","O","X","O","X"," ", " "};

        assertArrayEquals(expected, boardCells);
    }

    @Test
    public void unbeatableAiAlwaysBeatMediumAI() throws Exception {
        boolean unbeatableAINeverLose = true;
        Board board = new Board();
        Rules rules = new RulesFor3x3();
        Player player1 = new UnbeatableComputerPlayer(rules, board, "W", "L");
        Player player2 = new MediumComputerPlayer(rules, board, "L", "W");
        for (int i = 0; i < 1000; i++) {
            Game game = new Game(player1, player2, board);
            game.play();
            if (game.getWinnerSymbol() == "L") {
                unbeatableAINeverLose = false;
                board.printBoard();
            }
        }

        assertEquals(true, unbeatableAINeverLose);
    }
}
