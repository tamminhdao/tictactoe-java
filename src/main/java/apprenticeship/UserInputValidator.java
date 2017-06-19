package apprenticeship;

public class UserInputValidator {

    public boolean validateSymbolSelection(String symbolInput) {
        return symbolInput == "X" || symbolInput == "O";
    }

    public boolean validateCellSelection(int cellSelectionInput) {
        return 0 < cellSelectionInput && cellSelectionInput < 10;
    }
}
