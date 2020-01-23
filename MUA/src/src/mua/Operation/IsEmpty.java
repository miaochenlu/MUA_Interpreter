package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Support.NamespaceControl;
import src.mua.TYPE.BOOL;
import src.mua.TYPE.LIST;
import src.mua.TYPE.WORD;

public class IsEmpty extends BasicOperation {
    public IsEmpty() {operandNeedCount = 1;}

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        BasicElement op1 = BasicList.get(0);
        if(op1 instanceof LIST) {
            if(((LIST) op1).getListSize() == 0)
                return new BOOL("true");
            else return new BOOL("false");
        }
        else if (op1 instanceof WORD) {
            boolean res = NamespaceControl.getNamespaceList().hasVar(BasicList.get(0).val());
            if(res) return new BOOL("true");
            else return new BOOL("false");
        }
        return null;
    }
}
