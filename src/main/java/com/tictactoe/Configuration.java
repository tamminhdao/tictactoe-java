package com.tictactoe;

public class Configuration {
    private UserInput receiver;
    private UserInputValidator validator;
    private String input;
    public GamePreference gamePreference = new GamePreference();


    public Configuration(UserInput receiver, UserInputValidator validator) {
        this.receiver = receiver;
        this.validator = validator;
    }

    public GamePreference collectGamePreference(){
        System.out.println("Player 1 - Pick your symbol between [X] or [O]: ");
        this.askForPlayerOneSymbol();
        this.assignSymbolForPlayerTwo();
        System.out.println("Player 2 will take symbol " + gamePreference.player2Symbol + "\n");
        return this.gamePreference;
    }

    private String getInput() {
        this.input = this.receiver.obtainInput();
        return this.input;
    }

    private String chooseSymbol () {
        String playerSymbol = this.getInput();
        boolean validSymbol = validator.validateSymbolSelection(playerSymbol);
        while (!validSymbol) {
            System.out.println ("Invalid symbol selection. Choose between X and O.");
            playerSymbol = this.chooseSymbol();
            validSymbol = validator.validateSymbolSelection(playerSymbol);
        }
        return playerSymbol;
    }

    private void askForPlayerOneSymbol() {
        gamePreference.player1Symbol = chooseSymbol();
    }

    private void assignSymbolForPlayerTwo() {
        if (gamePreference.player1Symbol.equals("X")) {
            gamePreference.player2Symbol = "O";
        } else {
            gamePreference.player2Symbol = "X";
        }
    }
}
