package src.mua.Basic;

import src.mua.Exception.*;

import java.util.ArrayList;

public abstract class BasicOperation implements Foundation{
    public int operandNeedCount;
    public ArrayList<BasicElement> BasicList;

    /**
     * initialize Operation
     */
    public BasicOperation() {
        BasicList = new ArrayList<>();
    }

    /**
     * add operands to the Operation
     * BasicList is the operandsList
     * @param addOp
     * @throws OperandOverflowException
     */
    public void addOperand(Foundation addOp) throws OperandOverflowException, DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        if(BasicList.size() >= operandNeedCount)
            throw new OperandOverflowException(operandNeedCount);
        try{
            BasicList.add(addOp.getExecResult());
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * operand are ready and the operation can be executed
     * @return
     */
    public boolean ready2exec() {return BasicList.size() == operandNeedCount;}

    /**
     * executing the operation and return the result
     * @return
     */
    public abstract BasicElement getExecResult() throws NumFormatException, NotBoolException, ZeroDivisorException, DontSupportOperands;

}
