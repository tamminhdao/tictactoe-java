package com.tictactoe;

import java.util.Scanner;

public class Program {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private UserInput receiver = new UserInput(scanner);
    private Board board = new Board();
    private UserInputValidator validator = new UserInputValidator(board);
    private GameSettings menu = new GameSettings(receiver, validator, board);
    private GamePreference preference = menu.collectGamePreference();

    private Player player1 = preference.player1;
    private Player player2 = preference.player2;

    private String player1Symbol = preference.player1Symbol;
    private String player2Symbol = preference.player2Symbol;

    private Game tictactoe = new Game();

    public void run() {
        tictactoe.addBoard(board);
        tictactoe.addPlayerOne(player1);
        player1.addSymbol(player1Symbol);
        tictactoe.addPlayerTwo(player2);
        player2.addSymbol(player2Symbol);
        tictactoe.play();
    }
}
