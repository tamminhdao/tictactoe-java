package com.tictactoe;

public class main {
    public static void main (String arg[]) {
        Game game = new Game();
        OptionsMenu startMenu = new OptionsMenu(game);
        startMenu.open();
    }
}
