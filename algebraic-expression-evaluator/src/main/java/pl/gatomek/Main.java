package pl.gatomek;

public class Main {
    public static void main(String[] args) {
        dbgCalc( "10 * ( 2 + 2 )");
        dbgCalc( "( 5 + 5 ) * ( 2 + 2 )");
        dbgCalc( "( 1 + 2 ) * ( 3 * 4 + 5 )");
        dbgCalc( "( 1 + 2 ) * ( 3 + 4 * 5 )");
        dbgCalc( "-5 + ( 2 * ( 3 + 4 ) )");
    }

    private static void dbgCalc( String expr) {
        System.out.println( expr + " = " + calc( expr));
    }

    private static Integer calc( String expr) {
        return AlgebraicExpression.calc( expr);
    }
}