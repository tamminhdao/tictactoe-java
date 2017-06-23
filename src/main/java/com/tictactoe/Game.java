package com.tictactoe;

public class Game {
    private Rules rules = new RulesFor3x3();
    private Board board = new Board();
    private HumanPlayer player1;
    private HumanPlayer player2;

    public Game(HumanPlayer player1, HumanPlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    private void renderBoard() {
        board.drawGrid();
    }

    private void gameIntro() {
        System.out.println("3x3 Tic Tac Toe" + "\n");
    }

    private void announceWinner (String winner) {
        System.out.println("The winner is: " + winner);
    }

    private void announceTie () {
        System.out.println("It's a tie");
    }

    private void getResult() {
        if (this.rules.checkForWinner(board)) {
            this.announceWinner(this.rules.getWinner());
        } else {
            this.announceTie();
        }
    }

    public boolean gameInPlay() {
        return this.rules.gameProgress(this.board);
    }

    public void makeMove(Board board, HumanPlayer player) {
        board.drawGridWithOnlyCellNumberId();
        int cellSelection = player.obtainValidCellSelection();
        int cellIndex = cellSelection - 1;
        if (board.getSymbol(cellIndex).equals(" ")) {
            board.insertSymbol(player.getSymbol(), cellIndex);
        } else {
            System.out.println("Cell already occupied. Please select an empty cell.");
            this.makeMove(board, player);
        }
    }

    private void assignSymbol(HumanPlayer player1, HumanPlayer player2) {
        String symbol1 = player1.pickingSymbol();
        String symbol2 = player2.pickingSymbol();
        if (symbol2.equals(symbol1)) {
            System.out.println("Another player already picked that symbol.");
            symbol2 = player2.pickingSymbol();
        }
    }

    public void play() {
        this.gameIntro();
        this.assignSymbol(player1, player2);
        while (gameInPlay()) {
            this.makeMove(this.board, player1);
            this.renderBoard();
            if (!gameInPlay()) {
                break;
            }
            this.makeMove(this.board, player2);
            this.renderBoard();
        }
        this.getResult();
    }
}
