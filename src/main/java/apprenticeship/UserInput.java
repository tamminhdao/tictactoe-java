package apprenticeship;

import java.util.Scanner;

public class UserInput {
    private Scanner scanner;
    private UserInputValidator validator = new UserInputValidator();

    public UserInput(Scanner s) {
        this.scanner = s;
    }

    public int obtainValidCellSelection() {
        System.out.println("Enter your cell selection (0 - 8): ");
        int cell = this.scanner.nextInt();
        boolean isValid = validator.validateCellSelection(cell);
        if (!isValid) {
            cell = this.obtainValidCellSelection();
        }
        return cell;
    }
}
