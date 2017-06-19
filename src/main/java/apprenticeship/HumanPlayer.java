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
        board.insertSymbol(symbol, cellSelection);
    }
}
