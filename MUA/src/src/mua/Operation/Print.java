package src.mua.Operation;
import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;

public class Print extends BasicOperation{
    public Print() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        System.out.println(BasicList.get(0).val());
        return null;
    }
}