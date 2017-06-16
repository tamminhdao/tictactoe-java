package apprenticeship;

import java.util.Scanner;

public class ScannerImplementation implements InputReceiver {
    public int returnInput() {
        Scanner scanner = new Scanner(System.in);
        int scannerInput = scanner.nextInt();
        return scannerInput;
    }
}
