package src.mua.TYPE;

import src.mua.Basic.BasicElement;
import src.mua.Support.parseService;

import java.util.ArrayList;
import java.util.Arrays;

public class LIST extends BasicElement {
    ArrayList<BasicElement> listMember;
    ArrayList<String> listStrMember;
    StringBuilder listContentBuilder;
    String listContent;
    String val;

    public LIST(String Content) {
        val = Content;
        listMember = new ArrayList<>();
        listStrMember = new ArrayList<>();
        listContentBuilder = getVal();
        _parse();
        _stringList2MuaElementList();
    }

    private void _parse() {
        StringBuilder newlistContentBuilder  = new StringBuilder(listContentBuilder);
        listStrMember= new ArrayList<>(Arrays.asList(newlistContentBuilder.toString().split("\\s+")));
        listStrMember.remove("");
        listContent = new String();
        for(int i = 0; i < listStrMember.size(); i++)
            listContent = listContent + listStrMember.get(i) + " ";
    }

    public void _stringList2MuaElementList() {
        listMember = parseService.stringList2MuaElementList(listStrMember);
    }

    @Override
    public int elementType() { return 1; }

    public StringBuilder getVal() {
        StringBuilder res = new StringBuilder(val);
        for(int i = 0; i < res.length(); i++) {
            if(res.charAt(i) == '[') {
                res.delete(i, i+1);
                break;
            }
        }
        for(int i = res.length() - 1; i >= 0; i--) {
            if(res.charAt(i) == ']') {
                res.delete(i, i+1);
                break;
            }
        }
        return res;
    }
    @Override
    public String val() { return listContentBuilder.toString(); }

    public String valWithBracket() { return val; }

    public BasicElement getListElement(int pos) { return listMember.get(pos); }

    public int getListSize() { return listMember.size(); }

    public ArrayList<BasicElement> ListElement(){ return listMember; }
}
