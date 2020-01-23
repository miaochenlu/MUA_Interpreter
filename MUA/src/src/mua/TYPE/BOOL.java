package src.mua.TYPE;
import src.mua.Basic.BasicElement;

public class BOOL extends BasicElement{
    private boolean val;

    public BOOL(String initializer) {
        val = initializer.equals("true");
    }

    @Override
    public int elementType() {
        return 1;
    }

    @Override
    public String val() {
        return Boolean.toString(val);
    }
}
