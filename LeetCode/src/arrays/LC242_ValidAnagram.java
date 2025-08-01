package arrays;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 *
 * Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 *
 * https://leetcode.com/problems/valid-anagram/description/
 */
public class LC242_ValidAnagram {

    public boolean isAnagram(String s, String t) {

        int[] charArr = new int[128];

        for(char c : s.toCharArray()){

            charArr[c] ++;
        }

        for(char c : t.toCharArray()){

            charArr[c]--;
        }

        for(int i =0; i< 128; i++){

            if(charArr[i]!=0) return false;
        }

        return true;
    }
}
