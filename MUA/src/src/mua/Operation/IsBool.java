package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.BOOL;

public class IsBool extends BasicOperation {
    public IsBool() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        boolean res = (BasicList.get(0) instanceof BOOL);
        if(res) return new BOOL("true");
        else return new BOOL("false");

    }
}
