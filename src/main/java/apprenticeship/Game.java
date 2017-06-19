package apprenticeship;


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
        this.board.drawGridWithOnlyCellNumberId();
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

    private boolean gameInPlay() {
        return this.rules.gameProgress(this.board);
    }

    public void play() {
        this.gameIntro();

        while (gameInPlay()) {
            player1.makeMove(this.board);
            this.renderBoard();
            if (!gameInPlay()) {
                break;
            }
            player2.makeMove(this.board);
            this.renderBoard();
        }

        this.getResult();
    }
}
