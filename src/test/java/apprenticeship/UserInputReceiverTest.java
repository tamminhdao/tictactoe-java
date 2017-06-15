package apprenticeship;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;


public class UserInputReceiverTest {

    @Test
    public void initClassInstance() {
        UserInputReceiver inputReceiver = new UserInputReceiver(new Scanner(System.in));
    }
}
