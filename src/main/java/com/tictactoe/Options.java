package com.tictactoe;


public class Options {
    private UserInput receiver;
    private UserInputValidator validator = new UserInputValidator();
    private String input;
    public SelectedOptions selectedOptions = new SelectedOptions();


    public Options (UserInput receiver) {
        this.receiver = receiver;
    }

    public  SelectedOptions collectGamePreference(){
        boolean allOptionsSelected = false;
            while(!allOptionsSelected) {
                System.out.println("Player 1 - Pick your symbol between [X] or [O]: ");
                this.askForPlayerOneSymbol();
                System.out.println("Player 2 - Pick your symbol between [X] or [O]: ");
                this.askForPlayerTwoSymbol();

                while (selectedOptions.player2Symbol.equals(selectedOptions.player1Symbol)){
                    System.out.println("Another player already pick that symbol. Please pick again.");
                    selectedOptions.player2Symbol = chooseSymbol();
                }
                allOptionsSelected = true;
            }
        return this.selectedOptions;
    }

    private String getInput() {
        this.input = this.receiver.obtainInput();
        return this.input;
    }

    private String chooseSymbol () {
        String playerSymbol = this.getInput();
        boolean validSymbol = validator.validateSymbolSelection(playerSymbol);
        if (!validSymbol) {
            System.out.println ("Invalid symbol selection. Choose between X and O.");
            playerSymbol = this.chooseSymbol();
        }
        return playerSymbol;
    }

    private void askForPlayerOneSymbol() {
        selectedOptions.player1Symbol = chooseSymbol();
    }

    private void askForPlayerTwoSymbol() {
        selectedOptions.player2Symbol = chooseSymbol();
    }
}
