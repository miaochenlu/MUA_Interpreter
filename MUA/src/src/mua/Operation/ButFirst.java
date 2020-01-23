package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.TYPE.LIST;
import src.mua.TYPE.WORD;

public class ButFirst extends BasicOperation {
    public ButFirst()  {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        BasicElement op1 = BasicList.get(0);
        if(op1 instanceof LIST) {
            StringBuilder res = new StringBuilder();
            res.append("[");
            for(int i = 1; i < ((LIST) op1).getListSize(); i++) {
                if(((LIST) op1).getListElement(i) instanceof LIST)
                    res.append("[").append(((LIST) op1).getListElement(i).val()).append("]");
                else
                    res.append(((LIST) op1).getListElement(i).val());
                if(i != ((LIST) op1).getListSize() - 1)
                    res.append(" ");
            }
            res.append("]");
            return new LIST(res.toString());
        }
        else {
            StringBuilder res = new StringBuilder(op1.val());
            res.delete(0, 1);
            return new WORD(res.toString());
        }
    }
}
