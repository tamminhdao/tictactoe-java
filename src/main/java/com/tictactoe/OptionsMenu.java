package com.tictactoe;

import java.util.Scanner;

public class OptionsMenu {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private UserInput receiver = new UserInput(scanner);
    private Board board = new Board();
    private UserInputValidator validator = new UserInputValidator(board);
    private GameSettings menu = new GameSettings(receiver, validator);
    private Player player1;
    private Player player2;
    private GameInterface game;

    public OptionsMenu(GameInterface game) {
        this.game = game;
    }

    private String getInput() {
        return this.receiver.obtainInput();
    }

    private void listAllOptions() {
        System.out.println("Types of game:");
        System.out.println("1. Human Versus Human");
        System.out.println("2. Human Versus Computer");
        System.out.println("3. Computer Versus Human");
        System.out.println("4. Computer Versus Computer");
    }

    private int obtainValidGameTypeSelection() {
        int gameType = 0;
        System.out.println("Select one of the game types by picking a corresponding number [1-4]");
        boolean waitingForInput = true;
        while (waitingForInput) {
            try {
                String input = getInput();
                gameType = Integer.parseInt(input);
                waitingForInput = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Input must be a number");
            }
        }
        boolean isValid = validator.validateGameTypeSelection(gameType);
        if (!isValid) {
            System.out.println("The number you pick does not associate with any game type.");
            gameType = obtainValidGameTypeSelection();
        }
        return gameType;
    }

    private void humanVsHuman() {
        System.out.println("Starting a human vs. human game!");
        GamePreference preference = menu.collectGamePreference();
        this.player1 = new HumanPlayer (receiver, preference.player1Symbol, validator);
        this.player2 = new HumanPlayer (receiver, preference.player2Symbol, validator);
    }

    private void humanVsComputer() {
        System.out.println("Starting a human vs. computer game!");
        GamePreference preference = menu.collectGamePreference();
        this.player1 = new HumanPlayer (receiver, preference.player1Symbol, validator);
        this.player2 = new EasyComputerPlayer (preference.player2Symbol, board);
    }

    private void computerVsHuman() {
        System.out.println("Starting a computer vs. human game!");
        GamePreference preference = menu.collectGamePreference();
        this.player1 = new EasyComputerPlayer (preference.player1Symbol, board);
        this.player2 = new HumanPlayer (receiver, preference.player2Symbol, validator);
    }

    private void computerVsComputer() {
        System.out.println("Starting a computer vs. computer game!");
        GamePreference preference = menu.collectGamePreference();
        this.player1 = new EasyComputerPlayer (preference.player1Symbol, board);
        this.player2 = new EasyComputerPlayer (preference.player2Symbol, board);
    }

    private void setPlayers() {
        listAllOptions();
        int gameType = obtainValidGameTypeSelection();
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

    private void setUpNewGame() {
        game.addBoard(board);
        game.addPlayerOne(this.player1);
        game.addPlayerTwo(this.player2);
    }

    public void open() {
        setPlayers();
        setUpNewGame();
        game.play();
    }
}
