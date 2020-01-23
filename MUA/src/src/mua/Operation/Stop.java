package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;

public class Stop extends BasicOperation {
    public Stop() {
        operandNeedCount = 0;
    }

    @Override
    public BasicElement getExecResult() {
        return null;
    }

    @Override
    public int elementType() {
        return 0;
    }
}
