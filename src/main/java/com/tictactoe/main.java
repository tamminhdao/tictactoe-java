package com.tictactoe;

import java.util.Scanner;

public class main {
    public static void main (String arg[]) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        UserInput receiver = new UserInput(scanner);
        Board board = new Board();
        UserInputValidator validator = new UserInputValidator(board);
        Configuration menu = new Configuration(receiver, validator);
        GamePreference preference = menu.collectGamePreference();

        HumanPlayer player1 = new HumanPlayer(receiver, preference.player1Symbol, validator);
        HumanPlayer player2 = new HumanPlayer(receiver, preference.player2Symbol, validator);

        Game tictactoe = new Game(player1, player2, board);
        tictactoe.play();
    }
}
