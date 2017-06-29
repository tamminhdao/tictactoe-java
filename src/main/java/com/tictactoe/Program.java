package com.tictactoe;

import java.util.Scanner;

public class Program {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private UserInput receiver = new UserInput(scanner);
    private Board board = new Board();
    private UserInputValidator validator = new UserInputValidator(board);
    private GameSettings menu = new GameSettings(receiver, validator);
    private GamePreference preference = menu.collectGamePreference();

//    private HumanPlayer player1 = new HumanPlayer(receiver, preference.player1Symbol, validator);
//    private HumanPlayer player2 = new HumanPlayer(receiver, preference.player2Symbol, validator);


    private Player player1 = new EasyComputerPlayer("X", board);
    private Player player2 = new EasyComputerPlayer("O", board);

    private Game tictactoe = new Game(player1, player2, board);

    public void run() {
        tictactoe.play();
    }
}
