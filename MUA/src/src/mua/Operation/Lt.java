package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
//import src.src.mua.TYPE.*;
import src.mua.TYPE.*;

public class Lt extends BasicOperation {
    public Lt() {
        operandNeedCount = 2;
    }
    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        BasicElement op1 = BasicList.get(0);
        BasicElement op2 = BasicList.get(1);
        String res = "false";
        if(op1 instanceof WORD && op2 instanceof WORD) {
            if(op1.val().compareTo(op2.val()) < 0)
                res = "true";
            else res = "false";
        }
        else if(op1 instanceof NUM || op2 instanceof NUM) {
            if(Double.valueOf(op1.val()).compareTo(Double.valueOf(op2.val())) < 0)
                res = "true";
            else res = "false";
        }
        return new BOOL(res);
    }
}
