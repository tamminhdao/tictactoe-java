package apprenticeship;

import org.junit.Before;

public class GameTest {
    Game game;
    private RulesFor3x3 rules;
    private Board board;
    private UserInput receiver;

    @Before
    public void initGame() {
        game = new Game(board, rules, receiver);
    }
}
