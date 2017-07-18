package com.tictactoe;

import java.util.Scanner;

public class Program {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private UserInput receiver = new UserInput(scanner);
    private Board board = new Board();
    private UserInputValidator validator = new UserInputValidator(board);
    private GameSettings menu = new GameSettings(receiver, validator);
    private GamePreference preference = menu.collectGamePreference();
    private Rules rules = new RulesFor3x3();

    private Player player1 = new UnbeatableComputerPlayer(rules, board, preference.player1Symbol, preference.player2Symbol);
    //private Player player1 = new HumanPlayer(receiver, preference.player1Symbol, validator);
    private Player player2 = new UnbeatableComputerPlayer(rules, board, preference.player2Symbol, preference.player1Symbol);
    //private Player player2 = new HumanPlayer(receiver, preference.player2Symbol, validator);

    private Game tictactoe = new Game(player1, player2, board);

    public void run() {
        tictactoe.play();
    }
}
