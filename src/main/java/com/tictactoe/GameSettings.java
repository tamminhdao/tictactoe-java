package com.tictactoe;

public class GameSettings {
    private UserInput receiver;
    private UserInputValidator validator;
    private String input;
    private GamePreference gamePreference = new GamePreference();

    public GameSettings(UserInput receiver, UserInputValidator validator) {
        this.receiver = receiver;
        this.validator = validator;
    }

    public GamePreference collectGamePreference(){
        gamePreference.player1 = pickPlayerType("Player 1");
        gamePreference.player2 = pickPlayerType("Player 2");
        gamePreference.player1Symbol = chooseSymbol("Player 1");
        gamePreference.player2Symbol = chooseSymbol("Player 2");
        boolean uniqueSymbols = validator.playersHaveUniqueSymbols(gamePreference.player1Symbol, gamePreference.player2Symbol);
        this.checkForUniqueSymbols(uniqueSymbols);
        return this.gamePreference;
    }

    private void checkForUniqueSymbols(boolean uniqueSymbols) {
        while (!uniqueSymbols) {
            System.out.println("Another player already picked that symbol.");
            gamePreference.player2Symbol = chooseSymbol("Player 2");
            uniqueSymbols = validator.playersHaveUniqueSymbols(gamePreference.player1Symbol, gamePreference.player2Symbol);
        }
    }

    private String getInput() {
        this.input = this.receiver.obtainInput();
        return this.input;
    }

    private String chooseSymbol(String playerId) {
        System.out.println("Pick a unique symbol for " + playerId);
        String playerSymbol = this.getInput();
        boolean validSymbol = validator.validateSymbolSelection(playerSymbol);
        while (!validSymbol) {
            System.out.println ("Invalid symbol selection. Pick a string of any length.");
            playerSymbol = this.chooseSymbol(playerId);
            validSymbol = validator.validateSymbolSelection(playerSymbol);
        }
        return playerSymbol;
    }

    private Player pickPlayerType (String playerId) {
        System.out.println("Select the type of " + playerId + " by pressing [H] for a human player or [C] for a computer player");
        String playerType = this.getInput();
        if (playerType.equals("C")) {
            Player player = new EasyComputerPlayer();
            return player;
        } else if (playerType.equals("H")) {
            Player player = new HumanPlayer (receiver, validator);
            return player;
        } else {
            return pickPlayerType(playerId);
        }
    }
}
