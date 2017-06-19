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
            System.out.println ("Invalid cell number. Choose one of the available cells between 0 and 8");
            cell = this.obtainValidCellSelection();
        }
        return cell;
    }
}
