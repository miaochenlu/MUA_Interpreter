package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.LIST;
import src.mua.TYPE.WORD;

public class Last extends BasicOperation {
    public Last()  {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        BasicElement op1 = BasicList.get(0);
        if(op1 instanceof LIST) return ((LIST) op1).getListElement(((LIST) op1).getListSize() - 1);
        else return new WORD(String.valueOf(op1.val().charAt(op1.val().length() - 1)));
    }
}

