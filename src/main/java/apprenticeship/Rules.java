package apprenticeship;


public class Rules {
    private boolean hasWinner = false;
    private boolean isADraw = false;
    private String winner;
    private boolean gameInProgress = true;

    public boolean gameProgress(Board board) {
        if (board.countEmptyCells() == 0) {
            this.gameInProgress = false;
        } else if (this.hasWinner) {
            this.gameInProgress = false;
        }
        return this.gameInProgress;
    }

    public boolean checkForWinner(Board board) {
        this.checkForRowWin(board);
        this.checkForDiagonalWin(board);
        this.checkForColumnWin(board);
        return this.hasWinner;
    }

    public boolean endsInADraw() {
        if (!hasWinner && !gameInProgress) {
            this.isADraw = true;
        }
        return isADraw;
    }

    public String getWinner() {
        return this.winner;
    }

    private boolean checkForRowWin(Board board) {
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


    private boolean checkForColumnWin(Board board) {
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

    private boolean checkForDiagonalWin(Board board) {
        for (int cellIndex = 0, step = 4; cellIndex <= 2; cellIndex += 2, step -= 2) {
            if (winningByDiagonal(board, cellIndex, step)) {
                this.hasWinner = true;
                this.winner = board.getSymbol(cellIndex);
            }
        }
        return this.hasWinner;
    }

    private boolean winningByDiagonal(Board board, int cellIndex, int step) {
        return board.getSymbol(cellIndex) != " " &&
                board.getSymbol(cellIndex) == board.getSymbol(cellIndex + step) &&
                board.getSymbol(cellIndex + step) == board.getSymbol(cellIndex + 2 * step);
    }


}
