package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.COPE.Executor;
import src.mua.Exception.DontSupportOperands;
import src.mua.Exception.NotBoolException;
import src.mua.Exception.NumFormatException;
import src.mua.Exception.ZeroDivisorException;
import src.mua.TYPE.BOOL;
import src.mua.TYPE.LIST;
import src.mua.TYPE.NUM;
import src.mua.TYPE.WORD;

import java.util.List;

public class If extends BasicOperation {
    public If() {
        operandNeedCount = 3;
    }
    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() throws NotBoolException, NumFormatException, DontSupportOperands, ZeroDivisorException {
        Executor executor = new Executor();
        BOOL op1 = (BOOL)BasicList.get(0);
        LIST op2 = (LIST)BasicList.get(1);
        LIST op3 = (LIST)BasicList.get(2);

        if(op1.val().equals("true")) {
            try {
                executor.executeList(op2);
            }catch (Exception e) {
                throw e;
            }
        }
         else if(op1.val().equals("false")){
             try {
                 executor.executeList(op3);
             } catch (Exception e) {
                 throw e;
             }
        }
         else throw new NotBoolException();
        return null;
    }
}
