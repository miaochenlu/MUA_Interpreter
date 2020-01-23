package src.mua.Exception;

import src.mua.Basic.BasicException;

public class DontSupportOperands extends BasicException {
    public DontSupportOperands() {super("Don't support such operands for this operator");}
}
