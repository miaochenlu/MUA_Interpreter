package src.mua.Operation;
import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
//import src.src.mua.Support.*;
import src.mua.Support.*;
public class Erase extends BasicOperation{
    public Erase() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        NamespaceControl.getNamespaceList().eraseVar(BasicList.get(0).val());
        return null;
    }
}