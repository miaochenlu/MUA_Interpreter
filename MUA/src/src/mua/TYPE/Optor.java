//package src.src.mua.TYPE;
//import src.src.mua.Basic.BasicElement;
//import src.src.mua.Exception.DontSupportOperationException;
//import src.src.mua.Operation.OpHelper;

package src.mua.TYPE;
import src.mua.Basic.BasicElement;
import src.mua.Operation.operatorHelper;

public class Optor extends BasicElement{
    String val;
    public Optor(String initializer) {//throws DontSupportOperationException{
        operatorHelper oph = new operatorHelper();
        //if(oph.isOperation(initializer))
        val = initializer;
       // else
           // throw new DontSupportOperationException();
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public String val() {
        return val;
    }
}
