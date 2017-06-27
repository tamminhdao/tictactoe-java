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

    public String formatSymbol(String player1Symbol, String player2Symbol) {
        int len1 = player1Symbol.length();
        int len2 = player2Symbol.length();
        if (len1 > len2) {
            int lenDiffer = len1 - len2;
            player2Symbol = player2Symbol + createEmptySpaceBufferForShorterSymbol(lenDiffer);
            return player2Symbol;
        } else {
            int lenDiffer = len2 - len1;
            player1Symbol = player1Symbol + createEmptySpaceBufferForShorterSymbol(lenDiffer);
            return player1Symbol;
        }
    }

    public String createEmptySpaceBufferForShorterSymbol(int length) {
        String buffer = "";
        for (int i = 0; i < length; i++) {
            buffer += " ";
        }
        return buffer;
    }
}
