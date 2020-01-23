package src.mua.Operation;
//import src.src.mua.Basic.*;
import src.mua.Basic.*;
import src.mua.Support.NamespaceControl;
import src.mua.TYPE.LIST;

public class operatorHelper {
    static String[] OpList = {
            "make", "erase",
            "print", "read",
            "add", "sub", "mul", "div", "mod",
            "random", "int", "sqrt",
            "eq", "gt", "lt", "and", "or",
            "not", "isname", "isword", "isnumber", "isbool", "islist", "isempty",
            "thing", ":",
            "readlist",
            "repeat", "if", "output", "export", "stop",
            "word", "sentence", "list", "join",
            "first", "last", "butfirst", "butlast",
            "erall", "save", "load",
            "run",
    };

    public static boolean isOperation(String checkStr) {
        boolean res = false;
        for(String str : OpList) {
            if(checkStr.equals(str)) {
                res = true;
                break;
            }
        }
        return res;
    }

    public BasicOperation getFunctor(String str) {
        LIST func = (LIST) NamespaceControl.getNamespaceList().getVarValue(str);
        return new Function(str, func);
    }
    public BasicOperation getOptor(String str) {
        if(str.equals("make")) return new Make();
        else if(str.equals("erase")) return new Erase();
        else if(str.equals("print")) return new Print();
        else if(str.equals("read")) return new Read();
        else if(str.equals("thing")) return new Thing();
        else if(str.equals("add")) return new Add();
        else if(str.equals("sub")) return new Sub();
        else if(str.equals("mul")) return new Mul();
        else if(str.equals("div")) return new Div();
        else if(str.equals("mod")) return new Mod();
        else if(str.equals("eq")) return new Eq();
        else if(str.equals("gt")) return new Gt();
        else if(str.equals("lt")) return new Lt();
        else if(str.equals("not")) return new Not();
        else if(str.equals("and")) return new And();
        else if(str.equals("or")) return new Or();
        else if(str.equals("isname")) return new IsName();
        else if(str.equals("isword")) return new IsWord();
        else if(str.equals("isnumber")) return new IsNumber();
        else if(str.equals("isbool")) return new IsBool();
        else if(str.equals("islist")) return new IsList();
        else if(str.equals("readlist")) return new ReadList();
        else if(str.equals("repeat")) return new Repeat();
        else if(str.equals("if")) return new If();
        else if(str.equals("output")) return new Output();
        else if(str.equals("stop")) return new Stop();
        else if(str.equals("export")) return new Export();
        else if(str.equals("word")) return new MergeWord();
        else if(str.equals("sentence")) return new Sentence();
        else if(str.equals("list")) return new MergeList();
        else if(str.equals("join")) return new Join();
        else if(str.equals("first")) return new First();
        else if(str.equals("last")) return new Last();
        else if(str.equals("butfirst")) return new ButFirst();
        else if(str.equals("butlast")) return new ButLast();
        else if(str.equals("isempty")) return new IsEmpty();
        else if(str.equals("erall")) return new Erall();
        else if(str.equals("save")) return new Save();
        else if(str.equals("load")) return new Load();
        else if(str.equals("run")) return new Run();
        else if(str.equals("random")) return new Random();
        else if(str.equals("int")) return new Int();
        else if(str.equals("sqrt")) return new Sqrt();
        return null;
    }

    public BasicOperation getExprOptor(String str) {
        if(str.equals("+")) return new Add();
        else if(str.equals("-")) return new Sub();
        else if(str.equals("*")) return new Mul();
        else if(str.equals("/")) return new Div();
        else if(str.equals("%")) return new Mod();
        return null;
    }

}
