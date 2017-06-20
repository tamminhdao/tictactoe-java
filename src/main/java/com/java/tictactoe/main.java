package com.java.tictactoe;

import java.util.Scanner;

public class main {
    public static void main (String arg[]) {
        Scanner scanner = new Scanner(System.in);
        UserInput receiver = new UserInput(scanner);
        HumanPlayer player1 = new HumanPlayer("X", receiver);
        HumanPlayer player2 = new HumanPlayer("O", receiver);

        Game tictactoe = new Game(player1, player2);
        tictactoe.play();
    }
}
