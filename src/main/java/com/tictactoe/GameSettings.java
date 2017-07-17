package com.tictactoe;

public class GameSettings {
    private UserInput receiver;
    private UserInputValidator validator;
    private Board board;
    private GamePreference gamePreference = new GamePreference();

    public GameSettings(UserInput receiver, UserInputValidator validator, Board board) {
        this.receiver = receiver;
        this.validator = validator;
        this.board = board;
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
        String input = this.receiver.obtainInput();
        return input;
    }

    public String chooseSymbol(String playerId) {
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

    public Player pickPlayerType (String playerId) {
        System.out.println("Select the type of " + playerId + " by pressing [H] for a human player or [C] for a computer player");
        String playerType = this.getInput();
        if (playerType.equals("C")) {
            Player player = new EasyComputerPlayer(board);
            return player;
        } else if (playerType.equals("H")) {
            Player player = new HumanPlayer (receiver, validator);
            return player;
        } else {
            return pickPlayerType(playerId);
        }
    }

    public boolean askPlayerToRematch() {
        System.out.println("Do you want to play again? Enter [y] or [n]");
        String rematch = this.getInput();
        if (rematch.equals("y")) {
            return gamePreference.rematch = true;
        } else if (rematch.equals("n")) {
            System.out.println("Goodbye");
            return gamePreference.rematch = false;
        } else {
            return askPlayerToRematch();
        }
    }
}
