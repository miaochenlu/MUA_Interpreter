package src.mua.Operation;
import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Support.ScannerControl;
import src.mua.TYPE.WORD;

public class Read extends BasicOperation{
    public Read() {
        operandNeedCount = 0;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        String res = ScannerControl.nextLine();
        return new WORD(res);
    }
}