package com.tictactoe;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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
}
