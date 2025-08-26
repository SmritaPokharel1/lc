package string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 * Example 1:
 * Input: s = "leetcode"
 * Output: 0
 * Explanation:
 * The character 'l' at index 0 is the first character that does not occur at any other index.
 *
 * Example 2:
 * Input: s = "loveleetcode"
 * Output: 2
 *
 * Example 3:
 * Input: s = "aabb"
 * Output: -1
 *
 * https://leetcode.com/problems/first-unique-character-in-a-string/description/
 */
public class LC387_FirstUniqueCharacter {


    public int firstUniqCharWithAsciiArray(String s){

        int[] ascii = new int[128];

        for(char c : s.toCharArray()){

            ascii[c] ++;
        }

        for(int i =0; i< s.length(); i++){

            char c = s.charAt(i);

            if(ascii[c] == 1) return i;
        }

        return -1;
    }
    public int firstUniqCharWithMaps(String s) {

        Map<Character, Integer> freqMap = new HashMap();

        Map<Character,Integer> uniChars = new HashMap();

        List<Character> uniCharsList = new ArrayList();

        int result = 0;

        for(int i =0; i< s.length(); i++){

            Character c = s.charAt(i);

            int freq = freqMap.getOrDefault(c,0) +1;

            freqMap.put(c, freq);

            if(freq>1){

                uniChars.remove(c);
                uniCharsList.remove(c);
            }
            else{

                uniChars.put(c,i);
                uniCharsList.add(c);
            }
        }
        return uniCharsList.size()>0? uniChars.get(uniCharsList.get(0)): -1;
    }
}
