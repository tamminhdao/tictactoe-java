package apprenticeship;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static junit.framework.TestCase.assertEquals;

public class UserInputReceiverTest {
    @Test
    public void canCaptureAndReturnInput() {
        InputStream stream = new ByteArrayInputStream("100".getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(stream);
        UserInputReceiver receiver = new UserInputReceiver(scanner);
        int output = receiver.obtainCellSelection();
        assertEquals(output, 100);
    }
}
