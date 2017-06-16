package apprenticeship;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class UserInputReceiverTest {
    @Test
    public void canCaptureAndReturnInput() {
        TestScanner scanner = new TestScanner();
        UserInputReceiver receiver = new UserInputReceiver(scanner);
        int output = receiver.obtainCellSelection();
        assertEquals(output, 100);
    }
}
