package src.mua;
import src.mua.COPE.Interpreter;
import src.mua.Support.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NamespaceControl.createNamespaceList(new NamespaceList());     //create a new namespace
        ScannerControl.newScanner(new Scanner(System.in));  //provide global scanner service
        Interpreter CodeInterpreter = new Interpreter();    //create an interpreter

        String Code;
        int linenumber = 0;
        while(true) {
            if(ScannerControl.hasNext()) {
                linenumber++;
                Code = ScannerControl.nextLine();
                CodeInterpreter.execute(Code);
            } else return;
        }
    }
}
