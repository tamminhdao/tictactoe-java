package apprenticeship;

public class HumanPlayer {
    private String symbol;
    private UserInput receiver;
    
    public HumanPlayer(String symbol, UserInput receiver) {
        this.symbol = symbol;
        this.receiver = receiver;
    }

    public String getSymbol() {
        return symbol;
    }

    public void makeMove(Board board) {
        int cellSelection = receiver.obtainValidCellSelection();
        int cellIndex = cellSelection - 1;
        if (board.getSymbol(cellIndex).equals(" ")) {
            board.insertSymbol(symbol, cellIndex);
        } else {
            System.out.println("Cell already occupied. Please select an empty cell.");
            makeMove(board);
        }
    }
}
