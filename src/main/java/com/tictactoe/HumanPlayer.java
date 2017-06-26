package com.tictactoe;

public class HumanPlayer {
    private String input;
    private UserInput receiver;
    private UserInputValidator validator;
    private String symbol;

    public HumanPlayer(UserInput receiver, String symbol, UserInputValidator validator) {
       this.receiver = receiver;
       this.symbol = symbol;
       this.validator = validator;
    }

    public String getInput() {
        this.input = this.receiver.obtainInput();
        return this.input;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int obtainValidCellSelection() {
        int cell = 0;
        System.out.println("Enter your cell selection (1 - 9): ");
        boolean awaitingSelection = true;
        while (awaitingSelection)  {
            try {
                String selection = this.getInput();
                cell = Integer.parseInt(selection);
                awaitingSelection = false;
            } catch (NumberFormatException e) {
                System.out.println("Expected a number. Enter a number between 1 and 9: ");
            }
        }
        boolean isValid = validator.validateCellSelection(cell);
        if (!isValid) {
            System.out.println ("Invalid cell number. Choose one of the available cells between 1 and 9");
            cell = this.obtainValidCellSelection();
        }
        return cell;
    }
}
