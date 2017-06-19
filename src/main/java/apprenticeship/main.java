package apprenticeship;

import java.util.Scanner;

public class main {
    public static void main (String arg[]) {
        RulesFor3x3 threeThreeRules = new RulesFor3x3();
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        UserInput receiver = new UserInput(scanner);

        Game tictactoe = new Game(board, threeThreeRules, receiver);
        tictactoe.play();
    }
}
