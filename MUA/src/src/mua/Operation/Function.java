package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.COPE.Executor;
import src.mua.Exception.DontSupportOperands;
import src.mua.Exception.NotBoolException;
import src.mua.Exception.NumFormatException;
import src.mua.Exception.ZeroDivisorException;
import src.mua.Support.NamespaceControl;
import src.mua.TYPE.LIST;

public class Function extends BasicOperation {
    private String funcName;
    private LIST args;
    private LIST codes;
    public Function(String FuncName, LIST L) {
        funcName = FuncName;
        try {
            args = (LIST) L.getListElement(0);
            codes = (LIST) L.getListElement(1);
            operandNeedCount = args.getListSize();
        }catch (Exception e) {
            args = null;
            codes = null;
            operandNeedCount = 0;
        }
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() throws DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        NamespaceControl.getNamespaceList().createNamespace((NamespaceControl.getNamespaceList().getNamespace4varName(funcName)));
        for(int i = 0; i < operandNeedCount; i++)
            NamespaceControl.getNamespaceList().makeVarValue(args.getListElement(i).val(), BasicList.get(i));
        Executor codeExecutor = new Executor();
        try {
            codeExecutor.executeList(codes);
        } catch (Exception e) {
            throw e;
        }
        BasicElement returnVal = NamespaceControl.getNamespaceList().getReturnValue();
        NamespaceControl.getNamespaceList().deleteNamespace();
        return returnVal;
    }
}
