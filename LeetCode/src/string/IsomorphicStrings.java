package string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/isomorphic-strings/description/
public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        int m = s.length();
        int n = t.length();

        if (m != n) return false;

        if (m == 0 && n == 0) return true;

        if (m == 0 || n == 0) return false;

        Map<Character, Character> mapA = new HashMap<Character, Character>();
        Map<Character, Character> mapB = new HashMap<Character, Character>();

        for (int i = 0; i < m; i++) {

            Character a = s.charAt(i);
            Character b = t.charAt(i);

            if (a != b) {

                if (mapA.containsKey(a) && mapA.get(a) != b) return false;
                else {
                    mapA.put(a, b);
                }

                if (mapB.containsKey(b) && mapB.get(b) != a) return false;
                else {
                    mapB.put(b, a);
                }


            } else {
                if (mapA.containsKey(a) && mapA.get(a) != b) return false;
                if (mapB.containsKey(b) && mapB.get(b) != a) return false;
                mapA.put(a, b);
                mapB.put(b, a);
            }
        }

        return true;
    }

}
