package com.tictactoe;

public class Game {
    private Rules rules = new RulesFor3x3();
    private Board board;
    private Grid grid;
    private HumanPlayer player1;
    private HumanPlayer player2;

    public Game(HumanPlayer player1, HumanPlayer player2, Board board) {
        this.board = board;
        this.grid = new Grid(board);
        this.player1 = player1;
        this.player2 = player2;
    }

    private void renderBoard() {
        grid.draw();
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
        grid.drawGridWithOnlyCellNumberId(1);
        int cellSelection = player.obtainValidCellSelection();
        int cellIndex = cellSelection - 1;
        board.insertSymbol(player.getSymbol(), cellIndex);
    }

    public void play() {
        this.gameIntro();
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
