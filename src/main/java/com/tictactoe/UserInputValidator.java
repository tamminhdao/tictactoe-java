package com.tictactoe;

public class UserInputValidator {
    Board board;

    public UserInputValidator(Board board) {
        this.board = board;
    }

    public boolean validateSymbolSelection(String symbolInput) {
        return symbolInput.length() > 0 && !symbolInput.equals("\n");
    }

    public boolean validateCellSelection(int cellSelectionInput) {
        return 0 < cellSelectionInput && cellSelectionInput < 10 && (this.board.getSymbol(cellSelectionInput-1).equals(" "));
    }
}
