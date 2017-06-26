package com.tictactoe;

public class GameConfig {
    private UserInput receiver;
    private UserInputValidator validator = new UserInputValidator();
    private String input;
    public SelectedOptions selectedOptions = new SelectedOptions();


    public GameConfig(UserInput receiver) {
        this.receiver = receiver;
    }

    public  SelectedOptions collectGamePreference(){
        System.out.println("Player 1 - Pick your symbol between [X] or [O]: ");
        this.askForPlayerOneSymbol();
        this.assignSymbolForPlayerTwo();
        System.out.println("Player 2 will take symbol " + selectedOptions.player2Symbol + "\n");
        return this.selectedOptions;
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
        selectedOptions.player1Symbol = chooseSymbol();
    }

    private void assignSymbolForPlayerTwo() {
        if (selectedOptions.player1Symbol.equals("X")) {
            selectedOptions.player2Symbol = "O";
        } else {
            selectedOptions.player2Symbol = "X";
        }
    }
}
