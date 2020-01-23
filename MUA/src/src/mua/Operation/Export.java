package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Support.NamespaceControl;

public class Export extends BasicOperation {
    public Export() {
        operandNeedCount = 1;
    }

    @Override
    public BasicElement getExecResult() {
        NamespaceControl.getNamespaceList().export(BasicList.get(0).val());
        return null;
    }

    @Override
    public int elementType() {
        return 0;
    }
}
