package apprenticeship;


public class Rules {
    private boolean hasWinner = false;
    private String winner;
    private boolean gameInProgress = true;

    public boolean gameProgress(Board board) {
        if (board.countEmptyCells() == 0) {
            this.gameInProgress = false;
        }
        return this.gameInProgress;
    }

    public boolean checkForWinner() {
        return this.hasWinner;
    }

    public String getWinner() {
        return this.winner;

    }

    public int countEmptyCells() {
        return 9;
    }

    public boolean checkForRowWin(Board board) {
        for (int cellIndex = 0; cellIndex <= 6; cellIndex += 3) {
            if (winningByRow(board, cellIndex)) {
                this.hasWinner = true;
                this.winner = board.getSymbol(cellIndex);
            }
        }
        return this.hasWinner;
    }

    private boolean winningByRow(Board board, int cellIndex) {
        return board.getSymbol(cellIndex) != " " &&
                board.getSymbol(cellIndex) == board.getSymbol(cellIndex + 1) &&
                board.getSymbol(cellIndex + 1) == board.getSymbol(cellIndex +  2);
    }


    public boolean checkForColumnWin(Board board) {
        for (int cellIndex = 0; cellIndex <= 2; cellIndex ++) {
            if (winningByColumn(board, cellIndex)) {
                this.hasWinner = true;
                this.winner = board.getSymbol(cellIndex);
            }
        }
        return this.hasWinner;
    }

    private boolean winningByColumn(Board board, int cellIndex) {
        return board.getSymbol(cellIndex) != " " &&
                board.getSymbol(cellIndex) == board.getSymbol(cellIndex + 3) &&
                board.getSymbol(cellIndex + 3) == board.getSymbol(cellIndex +  6);
    }
}
