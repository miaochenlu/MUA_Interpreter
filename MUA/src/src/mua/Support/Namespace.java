package src.mua.Support;

import src.mua.Basic.BasicElement;
import src.mua.TYPE.NUM;

import java.util.ArrayList;
import java.util.HashMap;

public class Namespace {
    HashMap<String, BasicElement> variable_Value_Map;
    private Namespace parentNamespace;
    BasicElement returnValue;
    public Namespace(Namespace parent) {
        variable_Value_Map = new HashMap<String, BasicElement>();
        this.parentNamespace = parent;
        returnValue = null;
    }
    public Namespace getParentNamespace() { return parentNamespace; }

    public void makeVar(String name, BasicElement value) { variable_Value_Map.put(name, value); }

    public boolean hasVar(String var) { return !variable_Value_Map.containsKey(var); }

    public BasicElement getVar(String var) {
        if(var.equals("pi")) {
            try {
                makeVar("pi", new NUM("3.14159"));
            } catch (Exception e) {

            }
        }
        return variable_Value_Map.get(var);
   }


    public ArrayList<String> getVarNames() { return new ArrayList<>(variable_Value_Map.keySet()); }
    /**
     * 需不需要Exception呢？
     * @param var
     * @return
     */
    public boolean eraseVar(String var) {
        if(variable_Value_Map.containsKey(var)) {
            variable_Value_Map.remove(var);
            return true;
        } else return false;
    }
    public void eraseAllVar() { variable_Value_Map.clear(); }
    public void setReturnValue(BasicElement RVal) { returnValue = RVal; }
}
