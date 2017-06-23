package com.tictactoe;

import java.util.Scanner;

public class main {
    public static void main (String arg[]) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        UserInput receiver = new UserInput(scanner);
        HumanPlayer player1 = new HumanPlayer(receiver);
        HumanPlayer player2 = new HumanPlayer(receiver);

        Game tictactoe = new Game(player1, player2);
        tictactoe.play();
    }
}
