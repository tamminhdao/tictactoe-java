package apprenticeship;



public class UserInputReceiver {
    private InputReceiver inputReceiver;

    public UserInputReceiver (InputReceiver receiver) {
        this.inputReceiver = receiver;
    }

    public int obtainCellSelection() {
        System.out.println("Enter your cell selection (1 - 9): ");
        int cell = this.inputReceiver.returnInput();
        return cell;
    }
}
