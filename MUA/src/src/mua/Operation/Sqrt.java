package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Exception.NumFormatException;
import src.mua.TYPE.NUM;

public class Sqrt extends BasicOperation {
    public Sqrt() {operandNeedCount = 1;}

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() throws NumFormatException {
        BasicElement op1 = BasicList.get(0);
        try {
            return new NUM(String.valueOf(Math.sqrt(Double.valueOf(op1.val()))));
        } catch (NumFormatException e) {
            throw new NumFormatException();
        }
    }
}
