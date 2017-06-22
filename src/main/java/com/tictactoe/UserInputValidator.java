package com.tictactoe;

public class UserInputValidator {
    public boolean validateSymbolSelection(String symbolInput) {
        return symbolInput.equals("X") || symbolInput.equals("O");
    }

    public boolean validateCellSelection(int cellSelectionInput) {
        return 0 < cellSelectionInput && cellSelectionInput < 10;
    }
}
