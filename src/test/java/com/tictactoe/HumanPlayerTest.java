package com.tictactoe;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    private UserInput simulateHumanPlayerInput (String input) {
        InputStream stream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        UserInput receiver = new UserInput(scanner);
        return receiver;
    }

    @Test
    public void playerCanPickSymbol() throws Exception {
        UserInput receiver = simulateHumanPlayerInput("X");
        HumanPlayer player = new HumanPlayer(receiver);
        player.pickingSymbol();
        assertEquals("X", player.getSymbol());
    }

    @Test
    public void playerCanSelectCell() throws Exception {
        UserInput receiver = simulateHumanPlayerInput("1");
        HumanPlayer player = new HumanPlayer(receiver);
        int cellNumber = player.obtainValidCellSelection();
        assertEquals(1, cellNumber);
    }
}
