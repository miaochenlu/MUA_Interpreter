package src.mua.TYPE;
import src.mua.Basic.BasicElement;
public class WORD  extends BasicElement{
    private String val;

    public WORD(String initializer) {
        val = initializer;
    }

    @Override
    public int elementType() {
        return 1;
    }

    @Override
    public String val() {
        return val;
    }
}
