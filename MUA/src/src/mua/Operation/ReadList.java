package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Support.ScannerControl;
import src.mua.TYPE.LIST;

public class ReadList extends BasicOperation {
    public ReadList() {
        operandNeedCount = 0;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        String listContent  = ScannerControl.nextLine();
        return new LIST(listContent);
    }
}
