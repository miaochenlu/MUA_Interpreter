package src.mua.Operation;
import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
//import src.src.mua.Support.*;
import src.mua.Support.*;

public class Make extends BasicOperation{
    public Make() {
        operandNeedCount = 2;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        NamespaceControl.getNamespaceList().makeVarValue(BasicList.get(0).val(), BasicList.get(1));
        return null;
    }
}
