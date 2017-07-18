package com.tictactoe;

public class GameSettings {
    private UserInput receiver;
    private UserInputValidator validator;
    private Board board;
    private SelectedGameSettings selectedGameSettings = new SelectedGameSettings();

    public GameSettings(UserInput receiver, UserInputValidator validator, Board board) {
        this.receiver = receiver;
        this.validator = validator;
        this.board = board;
    }

    public SelectedGameSettings collectGamePreference(){
        selectedGameSettings.player1 = pickPlayerType("Player 1");
        selectedGameSettings.player2 = pickPlayerType("Player 2");
        selectedGameSettings.player1Symbol = chooseSymbol("Player 1");
        selectedGameSettings.player2Symbol = chooseSymbol("Player 2");
        boolean uniqueSymbols = validator.playersHaveUniqueSymbols(selectedGameSettings.player1Symbol, selectedGameSettings.player2Symbol);
        this.checkForUniqueSymbols(uniqueSymbols);
        return this.selectedGameSettings;
    }

    private void checkForUniqueSymbols(boolean uniqueSymbols) {
        while (!uniqueSymbols) {
            System.out.println("Another player already picked that symbol.");
            selectedGameSettings.player2Symbol = chooseSymbol("Player 2");
            uniqueSymbols = validator.playersHaveUniqueSymbols(selectedGameSettings.player1Symbol, selectedGameSettings.player2Symbol);
        }
    }

    private String getInput() {
        return this.receiver.obtainInput();
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
            return new EasyComputerPlayer(board);
        } else if (playerType.equals("H")) {
            return new HumanPlayer (receiver, validator);
        } else {
            return pickPlayerType(playerId);
        }
    }

    public boolean askToPlayAgain() {
        System.out.println("Do you want to play again? Enter [y] or [n]");
        String rematch = this.getInput();
        if (rematch.equals("y")) {
            return selectedGameSettings.rematch = true;
        } else if (rematch.equals("n")) {
            System.out.println("Goodbye");
            return selectedGameSettings.rematch = false;
        } else {
            return askToPlayAgain();
        }
    }
}
