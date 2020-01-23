package src.mua.TYPE;

import src.mua.Basic.BasicElement;
import src.mua.COPE.Executor;
import src.mua.Exception.DontSupportOperands;
import src.mua.Exception.NotBoolException;
import src.mua.Exception.NumFormatException;
import src.mua.Exception.ZeroDivisorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Expression extends BasicElement {
    private String Expression;
    private String parseExptrssion;
    private ArrayList<String> stringList;
    private BasicElement res;

    public Expression(String Expr) {
        Expression = Expr;
        parse();
        stringList = new ArrayList<>(Arrays.asList(parseExptrssion.split("\\s+")));
        stringList.remove("");
    }

    private void parse() {
        StringBuilder res1 = new StringBuilder();
        for(int i = 0; i < Expression.length();i++) {
            String substr = Expression.substring(i, i + 1);
            String operands = "+-*/%()";
            if(operands.contains(substr))
                res1.append(" ").append(substr).append(" ");
            else
                res1.append(substr);
        }
        parseExptrssion = res1.toString();

        StringBuilder res2 = new StringBuilder();
        int minusAttention = 0;
        Scanner strScan = new Scanner(parseExptrssion);

        //deal with pre '-'
        while(strScan.hasNext()) {
            String tmpstr = strScan.next();
            if(tmpstr.equals("-") && minusAttention == 0)
                res2.append("0 ");
            else if(tmpstr.equals("("))
                minusAttention = -1;

            minusAttention++;
            res2.append(tmpstr).append(" ");
        }
        parseExptrssion = res2.toString();
    }

    @Override
    public int elementType() {
        return 1;
    }

    public BasicElement getExprResult() throws DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        Executor executor = new Executor();
        try {
            res = executor.calculate(stringList);
        } catch (Exception e) {
            throw e;
        }
        return res;
    }
    @Override
    public String val() {
        return res.val();
    }
}
