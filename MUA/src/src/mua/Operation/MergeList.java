package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.LIST;

public class MergeList extends BasicOperation {
    public MergeList() {
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
            String res;
            res = "[";
            if (op1 instanceof LIST)
                res = res + ((LIST) op1).valWithBracket();
            else
                res = res + op1.val();

            res += " ";

            if (op2 instanceof LIST)
                res = res + ((LIST) op2).valWithBracket();
            else
                res = res + op2.val();
            res += "]";

            return new LIST(res);
        }catch (Exception e) {
            return null;
        }
    }
}
