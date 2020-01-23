package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
//import src.src.mua.TYPE.*;
import src.mua.Exception.NotBoolException;
import src.mua.TYPE.*;
public class And extends BasicOperation {
    public And() {
        operandNeedCount = 2;
    }
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
        if(op1.val().equals("true") && op2.val().equals("true"))
            res = "true";

        return new BOOL(res);
    }
}
