package pl.gatomek;

import java.util.List;

public class AlgebraicExpression {
    public static Integer calc( String expr) {
        List<String> items = ShuntingYard.calc(expr);
        return RPN.calc( items);
    }
}
