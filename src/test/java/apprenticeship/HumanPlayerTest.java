package apprenticeship;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static org.junit.Assert.*;


public class HumanPlayerTest {

    @Test
    public void playerCanMakeMove() throws Exception {
        Board board = new Board();
        InputStream stream = new ByteArrayInputStream("3".getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        UserInput receiver = new UserInput(scanner);
        HumanPlayer player = new HumanPlayer("X", receiver);
        player.makeMove(board);
        String cell3 = board.getSymbol(3);
        assertEquals(cell3, player.getSymbol());
    }
}
