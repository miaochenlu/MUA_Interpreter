package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Exception.NotBoolException;
import src.mua.Exception.NumFormatException;
import src.mua.TYPE.BOOL;
import src.mua.TYPE.NUM;

public class Or extends BasicOperation {
    public Or() { operandNeedCount = 2; }
    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() throws NotBoolException {
        BasicElement op1 = BasicList.get(0);
        BasicElement op2 = BasicList.get(1);
        String res = "false";
        if((!op1.val().equals("true") && !op1.val().equals("false")) || (!op2.val().equals("true") && !op2.val().equals("false")))
            throw new NotBoolException();
        if(op1.val().equals("true") || op2.val().equals("true")) {
            res = "true";
        }
        return new BOOL(res);
    }
}
