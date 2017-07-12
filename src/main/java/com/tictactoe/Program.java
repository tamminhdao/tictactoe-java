package com.tictactoe;

import java.util.Scanner;

public class Program {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private UserInput receiver = new UserInput(scanner);
    private Board board = new Board();
    private UserInputValidator validator = new UserInputValidator(board);
    private GameSettings menu = new GameSettings(receiver, validator);
    private GamePreference preference = menu.collectGamePreference();

    private Player player1 = new EasyComputerPlayer (preference.player1Symbol, board);
    private Player player2 = new EasyComputerPlayer (preference.player2Symbol, board);

    private Game tictactoe = new Game(player1, player2, board);

    public void run() {
        tictactoe.play();
    }
}
