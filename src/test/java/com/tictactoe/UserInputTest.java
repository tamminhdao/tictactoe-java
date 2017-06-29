package com.tictactoe;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static junit.framework.TestCase.assertEquals;


public class UserInputTest {
    @Test
    public void canCaptureAndReturnInput() {
        InputStream stream = new ByteArrayInputStream("X".getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        UserInput receiver = new UserInput(scanner);
        String output = receiver.obtainInput();
        assertEquals(output, "X");
    }
}
