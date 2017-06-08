package apprenticeship;


public class Rules {
    private boolean hasWinner;

    public boolean hasWinner() {
        this.hasWinner = false;
        return this.hasWinner;
    }

    public int countEmptyCells() {
        return 9;
    }
}
