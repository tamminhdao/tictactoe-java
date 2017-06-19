package apprenticeship;


public class Game {
    private Rules rules;
    private Board board;
    private UserInput receiver;

    public Game(Board board, Rules rules, UserInput receiver) {
        this.rules = rules;
        this.board = board;
        this.receiver = receiver;
    }

    public void play() {
        System.out.println("3x3 Tic Tac Toe" + "\n");
        this.board.drawGridWithOnlyCellNumberId();

        boolean gameStatus = this.rules.gameProgress(board);
        while (gameStatus) {
            int cell = this.receiver.obtainValidCellSelection();
            this.board.insertSymbol("X", cell);
            this.board.drawGrid();
            gameStatus = false;
        }
    }
}
