package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Support.NamespaceControl;

public class Output extends BasicOperation {
    public Output() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        NamespaceControl.getNamespaceList().setReturnValue(BasicList.get(0));
        return null;
    }
}
