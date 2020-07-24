package leetcode;

import java.util.HashMap;

public class IsIsomorphic {

    public static void main(String[] args) {

        //测试
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic( s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        //双向判断是否是同构，由 s ——> t 和 t ——> s
        return isIsomorphicHelper(s, t) && isIsomorphicHelper(t, s);
    }

    private static boolean isIsomorphicHelper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                map.put(c1, c2);
            }
        }
        return true;
    }
}
