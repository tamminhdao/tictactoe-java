package com.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private UserInputValidator validator = new UserInputValidator();

    public UserInput(Scanner s) {
        this.scanner = s;
    }

    public String pickingSymbol() {
        System.out.println("Pick between [X] or [O]: ");
        String symbol = this.scanner.nextLine();
        symbol = symbol.replaceAll("\\s+", "");
        System.out.println(symbol);
        boolean validSymbol = validator.validateSymbolSelection(symbol);
        System.out.println(symbol.length());
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
                cell = this.scanner.nextInt();
                break;
            } catch (InputMismatchException ime) {
                System.out.println("Expected int, got String. Enter a number between 1 and 9: ");
                this.scanner.next();
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
