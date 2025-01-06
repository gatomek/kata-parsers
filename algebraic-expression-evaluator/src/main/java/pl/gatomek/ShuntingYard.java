package pl.gatomek;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ShuntingYard {

    public static List<String> calc(String expr) {
        Stack<String> operatorStack = new Stack<>();
        List<String> output = new LinkedList<>();

        String[] elems = expr.split(" ");
        for (String s : elems) {
            if (Utils.isInteger(s)) {
                output.add(s);
            } else if (Utils.isOpeningBracket(s)) {
                operatorStack.push(s);
            } else if (Utils.isClosingBracket(s)) {
                while (!operatorStack.empty()) {
                    String op = operatorStack.pop();
                    if (Utils.isOpeningBracket(op))
                        break;

                    output.add(op);
                }
            } else if (Utils.isOperator(s)) {
                int precedence = getPrecedence(s);

                while (!operatorStack.empty()) {
                    String op = operatorStack.peek();
                    if (Utils.isOpeningBracket(op))
                        break;

                    int prec = getPrecedence(op);
                    if (prec >= precedence) {
                        op = operatorStack.pop();
                        output.add(op);
                    } else
                        break;
                }

                operatorStack.push(s);
            } else {
                throw new RuntimeException("Neither integer nor operator nor bracket found: " + s);
            }
        }

        while (!operatorStack.empty()) {
            String op = operatorStack.pop();
            output.add(op);
        }

        return output;
    }

    private static int getPrecedence(String oper) {
        if ("*".equals(oper) || "/".equals(oper))
            return 2;

        if ("+".equals(oper) || "-".equals(oper))
            return 1;

        throw new RuntimeException("Unknown operator: " + oper);
    }

}
