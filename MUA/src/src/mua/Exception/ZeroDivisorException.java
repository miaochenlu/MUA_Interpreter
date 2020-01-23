package src.mua.Exception;

import src.mua.Basic.BasicException;

public class ZeroDivisorException extends BasicException {
    public ZeroDivisorException() {super("Divisor can't be zero!");}
}
