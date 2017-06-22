package com.tictactoe;

import com.tictactoe.UserInput;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserInputTest {
    @Test
    public void canCaptureAndReturnValidInput() {
        InputStream stream = new ByteArrayInputStream("1".getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        UserInput receiver = new UserInput(scanner);
        int output = receiver.obtainValidCellSelection();
        assertEquals(output, 1);
    }

    @Test
    public void userCanSelectASymbolOfChoice() {
        InputStream stream = new ByteArrayInputStream("X".getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        UserInput receiver = new UserInput(scanner);
        String symbol = receiver.pickingSymbol();
        assertEquals(symbol, "X");
    }
}
