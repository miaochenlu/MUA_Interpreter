package src.mua.TYPE;
import src.mua.Basic.BasicElement;
//import src.src.mua.Exception.*;
import src.mua.Exception.*;
import src.mua.Operation.Int;

public class NUM extends BasicElement {
    private double val;

    public NUM(String initializer) throws NumFormatException {
        try {
            val = Double.parseDouble(initializer);
        } catch (NumberFormatException e) {
            throw new NumFormatException();
        }
    }

    @Override
    public int elementType() {
        return 1;
    }

    @Override
    public String val() {
        if((val - (int)val) < 0.02)
            return Integer.toString((int)val);
        else
            return Double.toString(val);
    }
}
