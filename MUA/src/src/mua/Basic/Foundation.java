package src.mua.Basic;
import src.mua.Exception.*;
import src.mua.Operation.*;
public interface Foundation {
    BasicElement getExecResult() throws NumFormatException, NotBoolException, ZeroDivisorException, DontSupportOperands;

    default boolean ready2exec() {
        return false;
    }

    //operand return 1 operation return 0
    int elementType();
    void addOperand(Foundation addOp) throws OperandOverflowException, DontSupportOperationException, DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException;
}
