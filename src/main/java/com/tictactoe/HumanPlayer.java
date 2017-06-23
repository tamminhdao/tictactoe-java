package com.tictactoe;

public class HumanPlayer {
    private String symbol;
    private String input;
    private UserInput receiver;
    private UserInputValidator validator = new UserInputValidator();

    public HumanPlayer(UserInput receiver) {
       this.receiver = receiver;
    }

    public String getInput() {
        this.input = this.receiver.obtainInput();
        return this.input;
    }

    public String pickingSymbol() {
        System.out.println("Pick between [X] or [O]: ");
        this.symbol = this.getInput();
        boolean validSymbol = validator.validateSymbolSelection(symbol);
        if (!validSymbol) {
            System.out.println ("Invalid symbol selection. Choose between X and O.");
            symbol = this.pickingSymbol();
        }
        return symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public int obtainValidCellSelection() {
        int cell;
        System.out.println("Enter your cell selection (1 - 9): ");
        while (true)  {
            try {
                String selection = this.getInput();
                cell = Integer.parseInt(selection);
                break;
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
