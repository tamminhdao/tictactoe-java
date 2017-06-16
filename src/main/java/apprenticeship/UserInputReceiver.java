package apprenticeship;

import java.util.Scanner;

public class UserInputReceiver {
    private Scanner scanner;

    public UserInputReceiver (Scanner s) {
        this.scanner = s;
    }

    public int obtainCellSelection() {
        System.out.println("Enter your cell selection (1 - 9): ");
        int cell = this.scanner.nextInt();
        return cell;
    }
}
