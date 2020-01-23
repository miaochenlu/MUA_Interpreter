package src.mua.Operation;

import src.mua.Basic.BasicElement;
import src.mua.Basic.BasicOperation;
import src.mua.COPE.Executor;
import src.mua.Support.parseService;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Load extends BasicOperation {
    public Load() {operandNeedCount = 1;}

    @Override
    public int elementType() {
        return 0;
    }

    @Override
    public BasicElement getExecResult() {
        String filename = BasicList.get(0).val();
        try {
            InputStreamReader inStream = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader buffer = new BufferedReader(inStream); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = buffer.readLine();
            while (line != null) {
                ArrayList<String> stringList = new ArrayList<>(Arrays.asList(line.split("\\s+")));
                ArrayList<BasicElement> elementList = parseService.stringList2MuaElementList(stringList);
                Executor executor = new Executor();
                executor.execute(elementList);
                line = buffer.readLine();
            }
        } catch (Exception e) {

        }
        return null;
    }
}
