package com.tictactoe;

import java.util.Scanner;

public class main {
    public static void main (String arg[]) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        UserInput receiver = new UserInput(scanner);
        Game game = new Game();
        OptionsMenu startMenu = new OptionsMenu(receiver, game);
        startMenu.open();
    }
}
