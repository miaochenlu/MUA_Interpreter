package src.mua.Support;

import src.mua.Basic.BasicElement;
import src.mua.TYPE.*;
import src.mua.Exception.*;

import java.util.ArrayList;
import java.util.Arrays;

public class parseService {

    static public ArrayList<BasicElement> stringList2MuaElementList(ArrayList<String> codeStringList)  {
        ArrayList<BasicElement> elementList = new ArrayList<>();
        for(int index = 0; index < codeStringList.size(); index++) {
            String tmpCodeString = codeStringList.get(index);
            if(tmpCodeString.length() >= 2 && tmpCodeString.substring(0, 2).equals("//")) {
                break;
            }
            try {
                elementList.add(new NUM(tmpCodeString));
            } catch (NumFormatException NFE) {
//check word
                if(tmpCodeString.charAt(0) == '"')
                    elementList.add(new WORD(tmpCodeString.substring(1)));
//check bool
                else if(tmpCodeString.equals("false") || tmpCodeString.equals("true"))
                    elementList.add(new BOOL(tmpCodeString));
//check thing
                else if(tmpCodeString.charAt(0) == ':') {
                    elementList.add(new Optor("thing"));
                    elementList.add(new WORD(tmpCodeString.substring(1)));
                }
//check list
                else if(tmpCodeString.charAt(0) == '[') {
                    int bracket = 0;
                    StringBuilder strBuilder = new StringBuilder();
                    while(true) {
                        if(index >= codeStringList.size()) {
                            String newlineCode = ScannerControl.nextLine();
                            codeStringList = new ArrayList<>(Arrays.asList(newlineCode.split("\\s+")));
                            codeStringList.remove("");
                            index = 0;
                        }
                        tmpCodeString = codeStringList.get(index);
                        for(int t = 0; t < tmpCodeString.length(); t++) {
                            if(tmpCodeString.charAt(t) == '[')
                                bracket++;
                            else break;
                        }
                        for(int t = tmpCodeString.length() - 1; t >= 0; t--) {
                            if(tmpCodeString.charAt(t) == ']')
                                bracket--;
                            else break;
                        }
                        strBuilder.append(tmpCodeString).append(" ");
                        if(bracket == 0)
                            break;
                        index++;
                    }
                    while(strBuilder.charAt(strBuilder.length() - 1) == ' ')
                        strBuilder.delete(strBuilder.length() - 1, strBuilder.length());

                    elementList.add(new LIST(strBuilder.toString()));
                }
//check expression
                else if(tmpCodeString.charAt(0) == '(')  {
                    int bracket = 0;
                    StringBuilder strBuilder = new StringBuilder();
                    while(true) {
                        if(index >= codeStringList.size()) {
                            String newlineCode = ScannerControl.nextLine();
                            codeStringList = new ArrayList<>(Arrays.asList(newlineCode.split("\\s+")));
                            codeStringList.remove("");
                            index = 0;
                        }
                        tmpCodeString = codeStringList.get(index);
                        for(int t = 0; t < tmpCodeString.length(); t++) {
                            if(tmpCodeString.charAt(t) == '(')
                                bracket++;
                            else break;
                        }
                        for(int t = tmpCodeString.length() - 1; t >= 0; t--) {
                            if(tmpCodeString.charAt(t) == ')')
                                bracket--;
                            else break;
                        }
                        strBuilder.append(tmpCodeString).append(" ");
                        if(bracket == 0)  break;
                        index++;
                    }
                    while(strBuilder.charAt(strBuilder.length() - 1) == ' ')
                        strBuilder.delete(strBuilder.length() - 1, strBuilder.length());
                    strBuilder.delete(0, 1);
                    strBuilder.delete(strBuilder.length() - 1, strBuilder.length());
                    elementList.add(new Expression(strBuilder.toString()));
                }
//it is a function
                else elementList.add(new Optor(tmpCodeString));
            }
        }
        return elementList;
    }
}
