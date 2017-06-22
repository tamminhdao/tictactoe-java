package com.tictactoe;

import com.tictactoe.UserInputValidator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserInputValidatorTest {
    private UserInputValidator userInputValidator;

    @Before
    public void canCreateValidator() {
        userInputValidator = new UserInputValidator();
    }

    @Test
    public void returnTrueWhenInputSymbolIsX() {
        String user_input = "X";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(result, true);
    }

    @Test
    public void returnTrueWhenInputSymbolIsO() {
        String user_input = "O";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(result, true);
    }

    @Test
    public void returnFalseWhenInputSymbolIsAnIncorrectString() {
        String user_input = "XOXOXO";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(result, false);
    }

    @Test
    public void returnFalseWhenInputSymbolIsAnEmptyString() {
        String user_input = "";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(result, false);
    }

    @Test
    public void returnFalseWhenInputSymbolIsASpecialCharacter() {
        String user_input = "#";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(result, false);
    }

    @Test
    public void returnFalseWhenInputSymbolIsANewLineCharacter() {
        String user_input = "\n";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(result, false);
    }

    @Test
    public void returnTrueWhenInputCellSelectionIsInRange() {
        int user_input = 1;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(result, true);
    }

    @Test
    public void returnFalseWhenInputCellSelectionIsOutOfRange() {
        int user_input = 10;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(result, false);
    }

    @Test
    public void returnFalseWhenInputCellSelectionIsANegativeNumber() {
        int user_input = -10;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(result, false);
    }
}
