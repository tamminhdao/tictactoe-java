package com.java.tictactoe;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    private UserInput simulateHumanPlayerCellSelection (String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        UserInput receiver = new UserInput(scanner);
        return receiver;
    }

    @Test
    public void playerCanMakeMove() throws Exception {
        Board board = new Board();
        UserInput receiver = simulateHumanPlayerCellSelection("3");
        HumanPlayer player = new HumanPlayer("X", receiver);
        player.makeMove(board);
        String cell3 = board.getSymbol(2);
        assertEquals(cell3, player.getSymbol());
    }
}
