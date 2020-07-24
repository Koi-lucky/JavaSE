package functionalInterface;

import java.util.function.Predicate;

// negate 取反的意思
public class Function_predicate_negate {

    public static boolean checkString(String s, Predicate<String> pre) {
        //return !pre.test(s);
        return pre.negate().test(s);
    }

    public static void main(String[] args) {
        String s = "abc11";
        boolean b = checkString( s, (String str) -> {
            return str.length() > 5;
        });
        System.out.println(b);
    }
}
