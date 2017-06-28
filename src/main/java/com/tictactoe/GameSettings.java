package com.tictactoe;

public class GameSettings {
    private UserInput receiver;
    private UserInputValidator validator;
    private String input;
    public GamePreference gamePreference = new GamePreference();

    public GameSettings(UserInput receiver, UserInputValidator validator) {
        this.receiver = receiver;
        this.validator = validator;
    }

    public GamePreference collectGamePreference(){
        gamePreference.player1Symbol = chooseSymbol("Player 1");
        gamePreference.player2Symbol = chooseSymbol("Player 2");
        boolean uniqueSymbols = validator.playersHaveUniqueSymbols(gamePreference.player1Symbol, gamePreference.player2Symbol);
        this.checkForUniqueSymbols(uniqueSymbols);
        return this.gamePreference;
    }

    private void checkForUniqueSymbols(boolean uniqueSymbols) {
        while (!uniqueSymbols) {
            System.out.println("Another player already pick that symbol.");
            gamePreference.player2Symbol = chooseSymbol("Player 2");
            uniqueSymbols = validator.playersHaveUniqueSymbols(gamePreference.player1Symbol, gamePreference.player2Symbol);
        }
    }

    private String getInput() {
        this.input = this.receiver.obtainInput();
        return this.input;
    }

    private String chooseSymbol(String playerId) {
        System.out.println(playerId + " - Pick your unique symbol: ");
        String playerSymbol = this.getInput();
        boolean validSymbol = validator.validateSymbolSelection(playerSymbol);
        while (!validSymbol) {
            System.out.println ("Invalid symbol selection. Pick a string of any length.");
            playerSymbol = this.chooseSymbol(playerId);
            validSymbol = validator.validateSymbolSelection(playerSymbol);
        }
        return playerSymbol;
    }
}
