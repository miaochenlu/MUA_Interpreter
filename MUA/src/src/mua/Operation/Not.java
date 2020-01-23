package src.mua.Operation;
import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Exception.NotBoolException;
import src.mua.TYPE.BOOL;

public class Not extends BasicOperation{
    public Not() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() throws NotBoolException {
        if(BasicList.get(0).val().equals("true"))
            return new BOOL("false");
        else if(BasicList.get(0).val().equals("false"))
            return new BOOL("true");
        else throw new NotBoolException();

    }
}
