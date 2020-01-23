package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.Support.NamespaceControl;
import src.mua.TYPE.LIST;
import src.mua.TYPE.WORD;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;

public class Save extends BasicOperation {
    public Save() {
        operandNeedCount = 1;
    }

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult(){
        HashMap<String, BasicElement> Varmap = new HashMap<>();

        for (String varname : NamespaceControl.getNamespaceList().getNamespaceList().getVarNames())
            Varmap.put(varname, NamespaceControl.getNamespaceList().getNamespaceList().getVar(varname));

        String filename = BasicList.get(0).val();
        File savefile = new File(filename);
        StringBuilder writeStringBuilder = new StringBuilder();
        for (HashMap.Entry<String, BasicElement> entry : Varmap.entrySet()) {
            String key = entry.getKey();
            BasicElement value = entry.getValue();
            if (value instanceof WORD) {
                writeStringBuilder.append(String.format("make \"%s \"%s\n", key, value.val()));
            } else if(value instanceof LIST) {
                writeStringBuilder.append(String.format("make \"%s %s\n", key, ((LIST) value).valWithBracket()));
            }
            else {
                writeStringBuilder.append(String.format("make \"%s %s\n", key, value.val()));
            }
        }
        try{
            savefile.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(savefile));
            out.write(writeStringBuilder.toString());
            out.flush();
            out.close();
        }catch (Exception e) {

        }
        return null;
    }
}
