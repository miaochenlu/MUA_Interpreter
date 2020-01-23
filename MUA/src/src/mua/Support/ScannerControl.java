package src.mua.Support;

import java.util.Scanner;

/**
 * provide global scanner service
 */
public class ScannerControl {
    private static Scanner scan;

    public ScannerControl() { }

    static public void newScanner(Scanner scanner) { scan = scanner; }
    static public boolean hasNext() { return scan.hasNext(); }
    static public String nextLine() { return scan.nextLine(); }
}