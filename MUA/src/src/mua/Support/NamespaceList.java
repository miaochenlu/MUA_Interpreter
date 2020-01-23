package src.mua.Support;

import src.mua.Basic.BasicElement;
import src.mua.TYPE.NUM;
import java.util.ArrayList;

/**
 * manage a list of namespace
 */
public class NamespaceList {
    private ArrayList<Namespace> namespaceList;

    public NamespaceList() { namespaceList = new ArrayList<>(); }
    public void createNamespace(Namespace var) { namespaceList.add(new Namespace(var)); }
    public void deleteNamespace() { namespaceList.remove(namespaceList.size() - 1); }
    public Namespace getNamespaceList() { return namespaceList.get(namespaceList.size() - 1); }
    public Namespace getNamespace4varName(String varName) {
        if(varName.equals("pi")) {
            try {
                namespaceList.get(namespaceList.size() - 1).makeVar("pi", new NUM("3.14159"));
            } catch (Exception e) {

            }
            return namespaceList.get(namespaceList.size() - 1);
        }

        Namespace returnNamespace = namespaceList.get(namespaceList.size() - 1);
        try {
            while (returnNamespace.hasVar(varName)) {
                returnNamespace = returnNamespace.getParentNamespace();
            }
            return returnNamespace;
        } catch (Exception e) {
            return null;
        }
    }

    public BasicElement getReturnValue() { return namespaceList.get(namespaceList.size() - 1).returnValue; }
    public void setReturnValue(BasicElement element) { namespaceList.get(namespaceList.size() - 1).returnValue = element; }
    public BasicElement getVarValue(String varName) {
        Namespace tmpNamespace = getNamespace4varName(varName);
        try {
            return tmpNamespace.getVar(varName);
        }catch (Exception e) {
            return null;
        }
    }
    public void makeVarValue(String name, BasicElement value) { namespaceList.get(namespaceList.size() - 1).makeVar(name, value); }
    public void eraseVar(String varName) {
        Namespace tmpNamespace = namespaceList.get(namespaceList.size() - 1);
        while(tmpNamespace.hasVar(varName)) {
            tmpNamespace = tmpNamespace.getParentNamespace();
            if(tmpNamespace == null) return;
        }
        tmpNamespace.eraseVar(varName);
    }
    public void eraseAllVar() { namespaceList.get(namespaceList.size() - 1).eraseAllVar(); }
    public boolean hasVar(String varName) {
        Namespace tmpNamespace = namespaceList.get(namespaceList.size() - 1);
        while(tmpNamespace.hasVar(varName)) {
            tmpNamespace = tmpNamespace.getParentNamespace();
            if(tmpNamespace == null) return false;
        }
        return true;
    }
    public void export(String name) {
        if(namespaceList.size() == 1) return;
        Namespace tmpNamespace = namespaceList.get(namespaceList.size() - 1);
        namespaceList.get(0).makeVar(name, getVarValue(name));
    }

}
