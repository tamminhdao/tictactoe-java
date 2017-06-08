package apprenticeship;


public class Rules {
    private boolean hasWinner = false;
    private boolean gameInProgress = true;

    public boolean gameProgress(Board board) {
        if (board.countEmptyCells() == 0) {
            this.gameInProgress = false;
        }
        return this.gameInProgress;
    }

    public boolean hasWinner() {
        return this.hasWinner;
    }

    public int countEmptyCells() {
        return 9;
    }
}
