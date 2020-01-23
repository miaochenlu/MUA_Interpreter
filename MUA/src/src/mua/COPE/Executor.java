package src.mua.COPE;

import src.mua.Basic.BasicElement;
import java.util.ArrayList;
import src.mua.Basic.BasicOperation;
import src.mua.Basic.Foundation;
import src.mua.Operation.*;
import src.mua.Exception.*;
import src.mua.TYPE.*;
import src.mua.Support.*;

public class Executor {
    private operatorHelper opHelper = new operatorHelper();
    private ArrayList<Foundation> OpList;

    public Executor() { OpList = new ArrayList<>(); }

//    public void execute2(ArrayList<BasicElement> elementList) {
//        while (elementList.size() > 0) {
//            BasicOperation newOp = null;
//            int size = elementList.size();
//            int j = 0;
//            for (j = size - 1; j >= 0; j--) {
//                if (elementList.get(j).elementType() == 0) {
//                    //operation instance
//                    newOp = opHelper.getOptor(elementList.get(j).val());
//                    break;
//                }
//            }
//            if (newOp != null) {
//                //如果是一个operation,将operandNeedCount数量的操作数压栈
//                int s = j + newOp.operandNeedCount;
//                while (s > j) {
//                    try {
//                        newOp.addOperand(elementList.get(s));
//                        elementList.remove(s);
//                        s--;
//                    } catch (OperandOverflowException OPFLOW) { }
//                }
//                BasicElement res = newOp.getExecResult();
//
//                if (res != null)
//                    elementList.set(j, res);
//                else {
//                    elementList.remove(j);
//                    if (elementList.size() != 0) {
//                        System.out.print("ERROR");
//                        return;
//                    }
//                }
//            } else {
//                if (elementList.size() == 1) {
//                } else
//                    System.out.println("ERROR");
//                return;
//            }
//        }
//    }

    /**
     * execute code
     * @param elementList
     * @return
     */
    public ArrayList<BasicElement> execute(ArrayList<BasicElement> elementList) throws DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        try {
            return executeCode(elementList, OpList);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * execute list
     * @param list
     */
    public void executeList(LIST list) throws DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        ArrayList<BasicElement> elementList = list.ListElement();
        ArrayList<Foundation> OperationList = new ArrayList<>();
        try {
            executeCode(elementList, OperationList);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * execute the element
     * @param elementList
     * @param opList
     * @return
     */
    private ArrayList<BasicElement> executeCode(ArrayList<BasicElement> elementList, ArrayList<Foundation> opList) throws DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        int i = 0;
        ArrayList<BasicElement> result = new ArrayList<>();
        boolean stopSignal = false;
        while (i < elementList.size()) {
            if (elementList.get(i).elementType() == 0) {                                //if this element is an operation
                if (operatorHelper.isOperation(elementList.get(i).val()))               //default function
                    opList.add(opHelper.getOptor(elementList.get(i).val()));
                else                                                                    //user-defined function
                    opList.add(opHelper.getFunctor(elementList.get(i).val()));
            }
            else if(elementList.get(i) instanceof Expression)                           //expression
                opList.add(((Expression) elementList.get(i)).getExprResult());
            else opList.add(elementList.get(i));                                        //Basic Element

            if (opList.get(opList.size() - 1) instanceof Stop)                          //Stop function
                stopSignal = true;

            try2Execute(opList);
            if (opList.size() == 1 && opList.get(0).ready2exec()) {
                try {
                    result.add(opList.remove(0).getExecResult());
                } catch (Exception e) {
                    throw e;
                }
                if (stopSignal) break;
            }
            i++;
        }
        return result;
    }

    private void try2Execute(ArrayList<Foundation> opList) {
        try {
            while (opList.size() > 1 && opList.get(opList.size() - 1).ready2exec()) {
                Foundation element = opList.remove(opList.size() - 1);
                try {
                    opList.get(opList.size() - 1).addOperand(element);
                } catch (DontSupportOperationException | OperandOverflowException ignored) {

                }
            }
        }catch (Exception e) {

        }
    }

    public BasicElement calculate(ArrayList<String>stringList) throws DontSupportOperands, ZeroDivisorException, NotBoolException, NumFormatException {
        String operandsPriority1 = "+-";
        String operandsPriority2 = "*/%";
        int bracket = 0;
        int i = 0;
        int pos = -1;   //mark operand position

        //search for priority1 operands "+-"
        for(i = stringList.size() - 1; i >= 0; i--) {
            if(stringList.get(i).equals("(")) bracket++;
            else if(stringList.get(i).equals(")")) bracket--;
            else if(bracket == 0) {
                pos = operandsPriority1.indexOf(stringList.get(i));
                if(pos >= 0) break;
            }

        }
        //if can't find priority1 operands
        //find priority2 operands
        if(pos < 0) {
            for(i = stringList.size() - 1; i >= 0; i--) {
                if(stringList.get(i).equals("(")) bracket++;
                else if(stringList.get(i).equals(")")) bracket--;
                else if(bracket == 0) {
                    pos = operandsPriority2.indexOf(stringList.get(i));
                    if(pos >= 0) break;
                }
            }
        }
        if(pos >= 0) {
            BasicOperation op = opHelper.getExprOptor(stringList.get(i));
            ArrayList<String> leftList = new ArrayList<>();
            ArrayList<String> rightList = new ArrayList<>();
            for(int j = 0; j < i; j++) leftList.add(stringList.get(j));
            for(int j = i + 1; j < stringList.size(); j++) rightList.add(stringList.get(j));
            try {
                op.addOperand(calculate(leftList));
            } catch (Exception ignored) {

            }
            try {
                op.addOperand(calculate(rightList));
            }catch (Exception ignored) {

            }
            try {
                return op.getExecResult();
            } catch (Exception e) {
                return null;
            }
        }

        Executor executor = new Executor();
        ArrayList<BasicElement> elementList = parseService.stringList2MuaElementList(stringList);
        ArrayList<BasicElement> res;
        try {
            res = executor.execute(elementList);
        } catch (Exception e) {
            throw e;
        }
        return res.get(0);
    }
}
