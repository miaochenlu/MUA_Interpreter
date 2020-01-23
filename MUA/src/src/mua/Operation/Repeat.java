package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.COPE.Executor;
import src.mua.Exception.DontSupportOperands;
import src.mua.Exception.NotBoolException;
import src.mua.Exception.NumFormatException;
import src.mua.Exception.ZeroDivisorException;
import src.mua.TYPE.LIST;

public class Repeat extends BasicOperation {
    public Repeat() {
        operandNeedCount = 2;
    }
    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() throws DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        double op1 = Double.valueOf(BasicList.get(0).val()).intValue();
        LIST op2 = (LIST) BasicList.get(1);
        Executor executor = new Executor();
        try {
            for (int i = 0; i < op1; i++)
                executor.executeList(op2);
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
