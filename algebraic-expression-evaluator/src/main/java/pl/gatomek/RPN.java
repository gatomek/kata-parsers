package pl.gatomek;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RPN {

    private RPN() {
    }

    public static Integer calc(String expr) {
        String[] elems = expr.split(" ");
        return calc(Arrays.stream(elems).toList());
    }

    public static Integer calc(List<String> expr) {
        Stack<Integer> stack = new Stack<>();

        for (String s : expr) {
            Integer i = Utils.parseInteger(s);
            if (i != null) {
                stack.push(i);
            }
            else if (Utils.isOperator(s)) {
                Integer next = stack.pop();
                Integer prev = stack.pop();

                switch (s) {
                    case "+":
                        stack.push(prev + next);
                        break;
                    case "-":
                        stack.push(prev - next);
                        break;
                    case "*":
                        stack.push(prev * next);
                        break;
                    case "/":
                        stack.push(prev / next);
                        break;
                    default:
                        throw new RuntimeException("Operator not known: " + s);
                }
            }
            else
                throw new RuntimeException("Neither integer nor operator found: " + s);
        }

        Integer result = stack.pop();
        assert stack.isEmpty();

        return result;
    }
}
