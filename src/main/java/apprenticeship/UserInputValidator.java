package apprenticeship;


public class UserInputValidator {
    public boolean validateSymbolSelection(String symbolInput) {
        if (symbolInput == "X" || symbolInput == "O") {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateCellSelection(int cellSelectionInput) {
        if (0 < cellSelectionInput && cellSelectionInput < 10) {
            return true;
        } else {
            return false;
        }
    }
}
