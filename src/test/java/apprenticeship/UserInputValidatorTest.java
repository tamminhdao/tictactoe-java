package apprenticeship;

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
    public void returnFalseWhenInputSymbolIsIncorrect() {
        String user_input = "XO";
        boolean result = userInputValidator.validateSymbolSelection(user_input);
        assertEquals(result, false);
    }

    @Test
    public void returnTrueWhenInputCellSelectionIsCorrect() {
        int user_input = 1;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(result, true);
    }

    @Test
    public void returnFalseWhenInputCellSelectionIsIncorrect() {
        int user_input = 10;
        boolean result = userInputValidator.validateCellSelection(user_input);
        assertEquals(result, false);
    }
}
