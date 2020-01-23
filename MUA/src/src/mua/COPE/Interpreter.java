package src.mua.COPE;

import java.util.ArrayList;
import src.mua.Basic.*;
import src.mua.Support.NamespaceControl;

public class Interpreter {
    private String Code;
    private Parser codeParser;
    private Executor codeExecutor;

    public Interpreter() {
        codeParser = new Parser();
        codeExecutor = new Executor();
        NamespaceControl.getNamespaceList().createNamespace(null);
    }

    /**
     * execute code
     */
    public void execute(String Code) {
        //first step: split one line code
        this.Code = Code;
        ArrayList<BasicElement> elementList;
        try {
            elementList = new ArrayList<>(codeParser.parse(Code));
            codeExecutor.execute(elementList);
        } catch (Exception exception) {
            System.out.println("ERROR: " + exception.getMessage());
        }
    }

}
