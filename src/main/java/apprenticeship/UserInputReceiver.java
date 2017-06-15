package apprenticeship;


import java.util.Scanner;


public class UserInputReceiver {
    private Scanner userInputReceiver;

    public UserInputReceiver (Scanner userInputReceiver) {
        this.userInputReceiver = userInputReceiver;
    }

    public int obtainCellSelection() {
        System.out.println("Enter your cell selection (1 - 9): ");
        int cell = this.userInputReceiver.nextInt();
        return cell;
    }
}
