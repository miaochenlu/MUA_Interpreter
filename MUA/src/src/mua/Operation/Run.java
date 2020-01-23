package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.COPE.Executor;
import src.mua.Exception.DontSupportOperands;
import src.mua.Exception.NotBoolException;
import src.mua.Exception.NumFormatException;
import src.mua.Exception.ZeroDivisorException;
import src.mua.TYPE.LIST;

public class Run extends BasicOperation {
    public Run() {
        operandNeedCount = 1;
    }
    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() throws DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        LIST op1 = (LIST) BasicList.get(0);
        Executor executor = new Executor();
        try {
            executor.executeList(op1);
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
