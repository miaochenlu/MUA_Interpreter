package src.mua.Basic;

import src.mua.Exception.DontSupportOperationException;
public abstract class BasicElement implements Foundation {
    @Override
    public BasicElement getExecResult() {
        return this;
    }
    public boolean ready2exec() {return true;}
    public abstract String val();

    @Override
    public void addOperand(Foundation addOp) throws DontSupportOperationException {
        throw new DontSupportOperationException();
    }
}
