package com.tictactoe;

import java.util.Scanner;

public class Program {
    private Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    private UserInput receiver = new UserInput(scanner);
    private Board board = new Board();
    private UserInputValidator validator = new UserInputValidator(board);
    private LanguageMenu languageMenu = new LanguageMenu(receiver);
    private Messages messages = languageMenu.chooseLanguage();
    private GameSettings menu = new GameSettings(receiver, validator, board, messages);
    private Rules rules = new RulesFor3x3();
    private SelectedGameSettings preference = menu.collectGamePreference();

    private Player player1 = preference.player1;
    private Player player2 = preference.player2;

    private String player1Symbol = preference.player1Symbol;
    private String player2Symbol = preference.player2Symbol;

    private Game tictactoe = new Game(messages);

    public void run() {
        tictactoe.addBoard(board);
        tictactoe.addPlayerOne(player1);
        player1.addSymbol(player1Symbol);
        player1.addOpponentSymbol(player2Symbol);
        player1.addRules(rules);
        tictactoe.addPlayerTwo(player2);
        player2.addSymbol(player2Symbol);
        player2.addOpponentSymbol(player1Symbol);
        player2.addRules(rules);
        tictactoe.play();
        askToPlayAgain();
    }

    private void askToPlayAgain() {
        boolean rematch = menu.askToPlayAgain();
        if (rematch) {
            tictactoe.clearBoardToStartANewGame();
            this.run();
        }
    }
}
