package apprenticeship;

public class main {
    public static void main (String arg[]) {
        ScannerImplementation scanner = new ScannerImplementation();
        UserInputReceiver input = new UserInputReceiver();
        int cell = input.obtainCellSelection();
        System.out.println("You selected: " + cell);
    }
}
