package src.mua.COPE;

import java.util.Arrays;
import java.util.ArrayList;
import src.mua.Basic.*;
import src.mua.Exception.*;
import src.mua.Support.parseService;

public class Parser {
    private ArrayList<BasicElement> elementList;
    private ArrayList<String> stringList;

    /**
     * change code to basicElement
     * @param Code
     * @return
     * @throws DontSupportOperationException
     */
    public ArrayList<BasicElement> parse(String Code) throws DontSupportOperationException{
        StringBuilder CodeBuilder = new StringBuilder(Code);
        for(int i = 0; i < CodeBuilder.length() - 1; ) {
            if(CodeBuilder.charAt(i) == ']' && CodeBuilder.charAt(i + 1) == '[') {
                CodeBuilder.insert(i + 1, " ");
                i = i + 3;
            }
            else if(CodeBuilder.charAt(i) == '(' || CodeBuilder.charAt(i) == ')') {
                CodeBuilder.insert(i, " ");
                CodeBuilder.insert(i + 2, " ");
                i = i + 3;
            }
            else i++;
        }
        Code = CodeBuilder.toString();
        //所有字符都已经被分割开来
        stringList = new ArrayList<>(Arrays.asList(Code.split("\\s+")));

        //接下来要转成MUA basicelement
        elementList = new ArrayList<>();
        stringList.remove("");

        elementList = parseService.stringList2MuaElementList(stringList);

//        System.out.println(elementList);
        return elementList;
    }

}
