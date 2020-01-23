package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Exception.*;
import src.mua.TYPE.NUM;

public class Mod extends BasicOperation {
    public Mod() {
        operandNeedCount = 2;
    }
    @Override
    public int elementType() {
        return 0;
    }

    /**
     * 这里还要注意除数为0
     * @return
     */
    @Override
    public BasicElement getExecResult() throws ZeroDivisorException, NumFormatException {
        double op1 = Double.parseDouble(BasicList.get(0).val());
        double op2 = Double.parseDouble(BasicList.get(1).val());
        if(op2 >= -0.001 && op2 <= 0.001)
            throw new ZeroDivisorException();
        double res = op1 % op2;

        try {
            return new NUM(Double.toString(res));
        } catch (NumFormatException NFE) {
            throw new NumFormatException();
        }
    }
}
