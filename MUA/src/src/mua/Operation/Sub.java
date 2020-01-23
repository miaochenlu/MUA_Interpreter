package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.NUM;
//import src.src.mua.Exception.*;
import src.mua.Exception.*;
public class Sub extends BasicOperation {
    public Sub() {
        operandNeedCount = 2;
    }
    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() throws NumFormatException {
        double op1 = Double.parseDouble(BasicList.get(0).val());
        double op2 = Double.parseDouble(BasicList.get(1).val());
        double res = op1 - op2;
        try {
            return new NUM(Double.toString(res));
        } catch (NumFormatException e) {
            throw new NumFormatException();
        }
    }
}
