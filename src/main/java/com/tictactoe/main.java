package com.tictactoe;

import java.util.Scanner;

public class main {
    public static void main (String arg[]) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        UserInput receiver = new UserInput(scanner);
        GameConfig menu = new GameConfig(receiver);
        GamePreference preference = menu.collectGamePreference();
        HumanPlayer player1 = new HumanPlayer(receiver, preference.player1Symbol);
        HumanPlayer player2 = new HumanPlayer(receiver, preference.player2Symbol);

        Game tictactoe = new Game(player1, player2);
        tictactoe.play();
    }
}
