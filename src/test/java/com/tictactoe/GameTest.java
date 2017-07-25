package com.tictactoe;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void playAFullGameWithTwoEasyComputerPlayers() throws Exception {
        Board board = new Board();
        Player player1 = new EasyComputerPlayer(board);
        Player player2 = new EasyComputerPlayer(board);
        player1.addSymbol("X");
        player2.addSymbol("O");
        Game game = new Game();
        game.addBoard(board);
        game.addPlayerOne(player1);
        game.addPlayerTwo(player2);
        game.play();
        String[] boardCells = board.getSymbol();
        String[] expected = {"X","O","X","O","X","O","X"," ", " "};

        assertArrayEquals(expected, boardCells);
    }

    @Test
    public void mediumComputerPlayerNeverLoseToEasyComputerPlayer() throws Exception {
        boolean mediumLevelComputerPlayerWins = true;
        Board board = new Board();
        Rules rules = new RulesFor3x3();
        Player player1 = new EasyComputerPlayer(board);
        Player player2 = new MediumComputerPlayer(board);
        player1.addSymbol("E");
        player2.addSymbol("M");
        player2.addOpponentSymbol("E");
        player2.addRules(rules);
        Game game = new Game();
        game.addBoard(board);
        game.addPlayerOne(player1);
        game.addPlayerTwo(player2);
        for (int i = 0; i < 1000; i++) {
            game.play();
            if (game.getWinnerSymbol() == "E") {
                mediumLevelComputerPlayerWins = false;
            } else {
                board.printBoard();
            }
        }
        assertEquals(mediumLevelComputerPlayerWins, true);
    }
}
