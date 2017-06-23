package com.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private UserInputValidator validator = new UserInputValidator();

    public UserInput(Scanner s) {
        this.scanner = s;
    }

    private String obtainInput() {
        String input = this.scanner.nextLine();
        input = input.replaceAll("\\s+", "");
        return input;
    }

    public String pickingSymbol() {
        System.out.println("Pick between [X] or [O]: ");
        String symbol = this.obtainInput();
        boolean validSymbol = validator.validateSymbolSelection(symbol);
        if (!validSymbol) {
            System.out.println ("Invalid symbol selection. Choose between X and O.");
            symbol = this.pickingSymbol();
        }
        return symbol;
    }

    public int obtainValidCellSelection() {
        int cell;
        System.out.println("Enter your cell selection (1 - 9): ");
        while (true)  {
            try {
                String selection = this.obtainInput();
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
