package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.BOOL;
import src.mua.TYPE.LIST;
import src.mua.TYPE.NUM;
import src.mua.TYPE.WORD;

public class First extends BasicOperation {
    public First()  {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        BasicElement op1 = BasicList.get(0);
        if(op1 instanceof LIST) return ((LIST) op1).getListElement(0);
        else return new WORD(String.valueOf(op1.val().charAt(0)));
    }
}
