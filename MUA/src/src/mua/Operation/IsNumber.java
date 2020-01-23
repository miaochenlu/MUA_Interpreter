package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.BOOL;
import src.mua.TYPE.NUM;

public class IsNumber extends BasicOperation {
    public IsNumber() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        boolean res = (BasicList.get(0) instanceof NUM);
        if(res) return new BOOL("true");
        else return new BOOL("false");
    }
}
