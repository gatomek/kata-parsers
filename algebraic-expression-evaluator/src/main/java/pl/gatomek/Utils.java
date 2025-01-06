package pl.gatomek;

public class Utils {

    private Utils() {}

    public static Integer parseInteger( String s) {
        Integer i = null;
        try {
            i = Integer.parseInt(s);
        }
        finally {
            return i;
        }
    }

    // todo: to refactor
    public static boolean isInteger( String s) {
        boolean vld = false;
        try {
            Integer.parseInt(s);
            vld = true;
        }
        finally {
            return vld;
        }
    }

    public static boolean isOperator( String s) {
        return "+".equals( s) || "-".equals( s) || "*".equals( s) || "/".equals( s);
    }

    public static boolean isOpeningBracket( String s) {
        return "(".equals( s);
    }

    public static boolean isClosingBracket( String s) {
        return ")".equals( s);
    }
}
