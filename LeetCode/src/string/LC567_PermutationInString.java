package string;


import java.util.ArrayList;
import java.util.List;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 *
 * https://leetcode.com/problems/permutation-in-string/description/
 */
public class LC567_PermutationInString {

    private List<String> result = new ArrayList<>();

    //Has bad performance and doesnt work for all use cases
    public boolean checkInclusion(String s1, String s2) {

        generatePermutation(s1);

        for(String s : result){

            if(s2.indexOf(s)!=-1) return true;
        }

        return false;
    }

    public void generatePermutation(String s){

        char[] arr = s.toCharArray();

        boolean[] used = new boolean[s.length()];

        backtrack(arr, new StringBuilder(), used);

    }

    public void backtrack(char[] arr, StringBuilder current, boolean[] used){

        if(current.length() == arr.length){
            result.add(current.toString());
            return;
        }

        for(int i = 0; i < arr.length; i ++){

            if(used[i]) continue;

            used[i] = true;

            current.append(arr[i]);

            backtrack(arr, current, used);

            current.deleteCharAt(current.length() -1);

            used[i] = false;
        }
    }
}
