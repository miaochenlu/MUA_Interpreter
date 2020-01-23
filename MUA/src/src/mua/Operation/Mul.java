package src.mua.Operation;

import src.mua.Basic.*;
import src.mua.Exception.*;
import src.mua.TYPE.NUM;

public class Mul extends BasicOperation {
    public Mul() {
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
        double res = op1 * op2;
        try {
            return new NUM(Double.toString(res));
        } catch (NumFormatException NFE) {
            throw new NumFormatException();
        }
    }
}
