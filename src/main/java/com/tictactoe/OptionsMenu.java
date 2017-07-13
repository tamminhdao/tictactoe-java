package com.tictactoe;

import java.util.Scanner;

public class OptionsMenu {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private UserInput receiver = new UserInput(scanner);
    private Board board = new Board();
    private UserInputValidator validator = new UserInputValidator(board);
    private GameSettings menu = new GameSettings(receiver, validator);

    public String getInput() {
        return this.receiver.obtainInput();
    }

    private void listAllOptions() {
        System.out.println("Types of game:");
        System.out.println("1. Human Versus Human");
        System.out.println("2. Human Versus Computer");
        System.out.println("3. Computer Versus Human");
        System.out.println("4. Computer Versus Computer");
        System.out.println("Select one of the game types by picking a corresponding number [1-4]");
    }

    private void humanVsHuman() {
        GamePreference preference = menu.collectGamePreference();
        Player player1 = new HumanPlayer (receiver, preference.player1Symbol, validator);
        Player player2 = new HumanPlayer (receiver, preference.player2Symbol, validator);
        Game tictactoe = new Game(player1, player2, board);
        tictactoe.play();
    }

    private void humanVsComputer() {
        GamePreference preference = menu.collectGamePreference();
        Player player1 = new HumanPlayer (receiver, preference.player1Symbol, validator);
        Player player2 = new EasyComputerPlayer (preference.player2Symbol, board);
        Game tictactoe = new Game(player1, player2, board);
        tictactoe.play();
    }

    private void computerVsHuman() {
        GamePreference preference = menu.collectGamePreference();
        Player player1 = new EasyComputerPlayer (preference.player1Symbol, board);
        Player player2 = new HumanPlayer (receiver, preference.player2Symbol, validator);
        Game tictactoe = new Game(player1, player2, board);
        tictactoe.play();
    }

    private void computerVsComputer() {
        GamePreference preference = menu.collectGamePreference();
        Player player1 = new EasyComputerPlayer (preference.player1Symbol, board);
        Player player2 = new EasyComputerPlayer (preference.player2Symbol, board);
        Game tictactoe = new Game(player1, player2, board);
        tictactoe.play();
    }

    public void open() {
        listAllOptions();
        String input = getInput();
        int gameType = Integer.parseInt(input);
        switch (gameType) {
            case 1: humanVsHuman();
            break;
            case 2: humanVsComputer();
            break;
            case 3: computerVsHuman();
            break;
            case 4: computerVsComputer();
            break;
        }
    }
}
