package com.tictactoe;

public class GameSettings {
    private UserInput receiver;
    private UserInputValidator validator;
    private Board board;
    private SelectedGameSettings selectedGameSettings = new SelectedGameSettings();
    private Messages messages;

    public GameSettings(UserInput receiver, UserInputValidator validator, Board board, LanguageMenu menu) {
        this.receiver = receiver;
        this.validator = validator;
        this.board = board;
        this.messages = menu.chooseLanguage();
    }

    public SelectedGameSettings collectGamePreference(){
        selectedGameSettings.player1 = pickPlayerType("1");
        selectedGameSettings.player2 = pickPlayerType("2");
        selectedGameSettings.player1Symbol = chooseSymbol("1");
        selectedGameSettings.player2Symbol = chooseSymbol("2");
        boolean uniqueSymbols = validator.playersHaveUniqueSymbols(selectedGameSettings.player1Symbol, selectedGameSettings.player2Symbol);
        this.checkForUniqueSymbols(uniqueSymbols);
        return this.selectedGameSettings;
    }

    private void checkForUniqueSymbols(boolean uniqueSymbols) {
        while (!uniqueSymbols) {
            System.out.println(messages.GameSettings_checkForUniqueSymbols);
            selectedGameSettings.player2Symbol = chooseSymbol("2");
            uniqueSymbols = validator.playersHaveUniqueSymbols(selectedGameSettings.player1Symbol, selectedGameSettings.player2Symbol);
        }
    }

    private String getInput() {
        return this.receiver.obtainInput();
    }

    public String chooseSymbol(String playerId) {
        System.out.println(messages.GameSettings_chooseSymbol + playerId);
        String playerSymbol = this.getInput();
        boolean validSymbol = validator.validateSymbolSelection(playerSymbol);
        while (!validSymbol) {
            System.out.println (messages.GameSettings_invalidSymbol);
            playerSymbol = this.chooseSymbol(playerId);
            validSymbol = validator.validateSymbolSelection(playerSymbol);
        }
        return playerSymbol;
    }

    public Player pickPlayerType (String playerId) {
        System.out.println(messages.GameSettings_pickPlayerTypePart1 + playerId + messages.GameSettings_pickPlayerTypePart2);
        String playerType = this.getInput();
        if (playerType.equals("E")) {
            return new EasyComputerPlayer(board);
        } else if (playerType.equals("H")) {
            return new HumanPlayer (receiver, validator);
        } else if (playerType.equals("M")) {
            return new MediumComputerPlayer(board);
        } else if (playerType.equals("U")) {
            return new UnbeatableComputerPlayer(board);
        } else {
            return pickPlayerType(playerId);
        }
    }

    public boolean askToPlayAgain() {
        System.out.println(messages.GameSettings_askToPlayAgain);
        String rematch = this.getInput();
        if (rematch.equals("y")) {
            return selectedGameSettings.rematch = true;
        } else if (rematch.equals("n")) {
            System.out.println(messages.GameSettings_goodbye);
            return selectedGameSettings.rematch = false;
        } else {
            return askToPlayAgain();
        }
    }
}
