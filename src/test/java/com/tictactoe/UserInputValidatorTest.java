package com.tictactoe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserInputValidatorTest {
    private UserInputValidator userInputValidator;
    private Board board;

    @Before
    public void canCreateValidator() {
        board = new Board();
        userInputValidator = new UserInputValidator(board);
    }

    @Test
    public void returnTrueWhenInputSymbolIsASingleCharacterString() {
        String user_input = "a";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(true, result);
    }

    @Test
    public void returnTrueWhenInputSymbolIsAMultiCharacterString() {
        String user_input = "XoxO";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(true, result);
    }

    @Test
    public void returnFalseWhenInputSymbolIsAnEmptyString() {
        String user_input = "";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(false, result);
    }

    @Test
    public void returnTrueWhenInputSymbolIsASpecialCharacter() {
        String user_input = "#";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(true, result);
    }

    @Test
    public void returnFalseWhenInputSymbolIsANewLineCharacter() {
        String user_input = "\n";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(false, result);
    }

    @Test
    public void returnTrueWhenInputCellSelectionIsInRange() {
        int user_input = 1;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(true, result);
    }

    @Test
    public void returnFalseWhenInputCellSelectionIsOutOfRange() {
        int user_input = 10;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(false, result);
    }

    @Test
    public void returnFalseWhenInputCellSelectionIsANegativeNumber() {
        int user_input = -10;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(false, result);
    }
    @Test
    public void returnFalseIfCellIsAlreadyOccupied() throws Exception {
        board.insertSymbol("X", 0);
        int user_input = 1;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(false, result);
    }
}
