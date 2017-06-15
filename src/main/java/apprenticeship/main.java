package apprenticeship;

import java.util.Scanner;


public class main {
    public static void main (String arg[]) {
        UserInputReceiver input = new UserInputReceiver(new Scanner(System.in));
        int cell = input.obtainCellSelection();
        System.out.println("You selected: " + cell);
    }
}
