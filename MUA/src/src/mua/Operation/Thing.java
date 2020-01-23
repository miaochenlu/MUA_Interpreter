package src.mua.Operation;
import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
//import src.src.mua.Support.*;
import src.mua.Support.*;
public class Thing extends BasicOperation{
    public Thing() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        return NamespaceControl.getNamespaceList().getVarValue(BasicList.get(0).val());
    }
}