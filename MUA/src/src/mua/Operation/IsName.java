package src.mua.Operation;
import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
//import src.src.mua.Support.*;
import src.mua.Support.*;
import src.mua.TYPE.BOOL;

public class IsName extends BasicOperation{
    public IsName() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        boolean res = NamespaceControl.getNamespaceList().hasVar(BasicList.get(0).val());
        if(res) return new BOOL("true");
        else return new BOOL("false");
    }
}
