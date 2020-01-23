package src.mua.Exception;
import src.mua.Basic.*;
//import src.src.mua.Exception.*;


public class OperandOverflowException extends BasicException {
    public OperandOverflowException(int operandNeedCount) {
//        System.out.println("Too much operands, only need " + operandNeedCount + " operands");
        super("Don't support such operation!");
    }
}
