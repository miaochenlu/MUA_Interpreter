package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicException;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.NUM;
import src.mua.TYPE.WORD;

public class MergeWord extends BasicOperation {
    public MergeWord() {
        operandNeedCount = 2;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        try {
            BasicElement op1 = BasicList.get(0);
            BasicElement op2 = BasicList.get(1);
            if (!(op1 instanceof WORD)) return null;
            return new WORD(op1.val() + op2.val());
        }catch (Exception e) {
            return null;
        }
    }
}
