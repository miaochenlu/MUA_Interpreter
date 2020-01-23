package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Support.NamespaceControl;

public class Erall extends BasicOperation {
    public Erall() {operandNeedCount = 0;}

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        NamespaceControl.getNamespaceList().eraseAllVar();
        return null;
    }
}
