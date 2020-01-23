package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.LIST;


public class Join extends BasicOperation {
    public Join() {
        operandNeedCount = 2;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        try {
            LIST op1 = (LIST) BasicList.get(0);
            BasicElement op2 = BasicList.get(1);

            String res;
            res = "[";
            if (op1.getListSize() != 0) {
                res += op1.val();
                res += " ";
            }

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
