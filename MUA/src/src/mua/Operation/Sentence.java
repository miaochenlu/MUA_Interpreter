package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.LIST;

public class Sentence extends BasicOperation {
    public Sentence() {
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
            String res = new String();
            res = "[" + op1.val() + " " + op2.val() + "]";
            return new LIST(res);
        }catch (Exception e) {
            return null;
        }
    }
}
