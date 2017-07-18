package com.tictactoe;

public class Game {
    private Rules rules = new RulesFor3x3();
    private Board board;
    private Grid grid;
    private Player player1;
    private Player player2;

    public void addBoard(Board board){
        this.board = board;
        this.grid = new Grid(board);
    }

    public void addPlayerOne(Player player1) {
        this.player1 = player1;
    }

    public void addPlayerTwo(Player player2) {
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
        String winner = this.rules.checkForWinner(board);
        if (!winner.equals("")) {
            this.announceWinner(winner);
        } else {
            this.announceTie();
        }
    }

    public boolean gameInPlay() {
        return (!this.rules.endsInADraw(this.board) && this.rules.checkForWinner(board).equals(""));
    }

    private void notifyPlayersTurn(Player player) {
        System.out.println("Player " + player.getSymbol() + "'s turn. \n");
    }

    public void makeMove(Board board, Player player) {
        grid.drawGridWithOnlyCellNumberId(1);
        int CELL_OFFSET = 1;
        this.notifyPlayersTurn(player);
        int cellSelection = player.obtainValidCellSelection();
        int cellIndex = cellSelection - CELL_OFFSET;
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

    public void clearBoardToStartANewGame() {
        board.populateBoardWithEmptyCells();
    }
}
